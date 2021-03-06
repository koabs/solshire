package com.solshire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.solshire.mapper.RichesMapper;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;
import com.solshire.service.RichesService;
import com.solshire.util.BeanCopierUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("richesService")
public class RichesServiceImpl extends BaseServiceImpl<Riches, Integer> implements RichesService {

    @Autowired
    RichesMapper richesMapper;


    @Override
    public PageInfo<RichesEntity> queryByPage(RichesQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<RichesEntity> result = richesMapper.queryByPage(query);
        for (RichesEntity info : result) {
            info.setLevelName(getLevel(info.getRicheid()));
        }
        return new PageInfo<>(result);
    }

    @Override
    public List<RichesEntity> queryChildren(Integer richeid) {
        RichesQuery query = new RichesQuery();
        query.setParentRicheId(richeid);
        List<RichesEntity> result = richesMapper.queryChildren(query);
        for (RichesEntity info : result) {
            info.setLevelName(getLevel(info.getRicheid()));
        }
        return result;
    }

    @Override
    public PageInfo<RichesEntity> queryChildrenByPage(RichesQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<RichesEntity> result = richesMapper.queryChildren(query);
        for (RichesEntity info : result) {
            info.setLevelName(getLevel(info.getRicheid()));
        }
        return new PageInfo<>(result);
    }

    @Override
    public RichesEntity queryById(Integer richeId) {
        Riches info = selectByPk(richeId);
        // 获取级别
        // Integer level = richesMapper.queryLevel(richeId,1);
        RichesEntity result = BeanCopierUtils.copyProperties(info,RichesEntity.class);
        result.setLevel(getLevel(richeId));
        return result;
    }

    @Override
    public void save(Riches info) {
        if (info.getRicheid() == null) {
            info.setAddtime(new Date());
            info.setState((short) 0);
            insert(info);
        } else {
            update(info);
        }
    }

    @Override
    public Map<String, Riches> queryCertifyNoMap(List<String> certifyNos) {
        Map<String, Riches> map = new HashedMap();
        if (certifyNos.size()>0) {
            List<Riches> infos = richesMapper.queryByCertifyNos(StringUtils.join(certifyNos, ","));
            map = Maps.uniqueIndex(infos, new Function<Riches, String>() {
                @Nullable
                @Override
                public String apply(@Nullable Riches riches) {
                    return riches.getCertifyno();
                }
            });
        }
        return map;
    }

    @Override
    public Map<Integer, Riches> queryIdMap(List<Integer> ids) {
        Map<Integer, Riches> map = new HashedMap();
        if (ids.size()>0) {
            List<Riches> infos = selectByIds(ids);
            map = Maps.uniqueIndex(infos, new Function<Riches, Integer>() {
                @Nullable
                @Override
                public Integer apply(@Nullable Riches riches) {
                    return riches.getRicheid();
                }
            });
        }
        return map;
    }

    String getLevel(Integer richId) {
        String levelName = null;
        Integer levelNum = richesMapper.queryLevel(richId,1);
        switch (levelNum) {
            case 1:
                levelName = "顾问";
                break;
            case 2:
                levelName = "经理";
                break;
            case 3:
                levelName = "高级经理";
                break;
            case 4:
                levelName = "总监";
                break;
            case 5:
                levelName = "高级总监";
                break;
            case 6:
                levelName = "资深总监";
                break;
            case 7:
                levelName = "事业合伙人";
                break;
            default:
                levelName = "顾问";
                break;
        }
        return levelName;
    }
}