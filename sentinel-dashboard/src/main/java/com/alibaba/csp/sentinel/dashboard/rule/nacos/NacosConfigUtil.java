package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.util.JSONUtils;
import com.alibaba.csp.sentinel.slots.block.Rule;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anthony
 * @create 2022/1/19
 * @desc
 **/
public final class NacosConfigUtil {

    public static final String GROUP_ID = "SENTINEL_GROUP";

    public static final String FLOW_DATA_ID_POSTFIX = "-flow-rules.json";
    public static final String DEGRADE_DATA_ID_POSTFIX = "-degrade-rules.json";
    public static final String SYSTEM_DATA_ID_POSTFIX = "-system-rules.json";
    public static final String PARAM_FLOW_DATA_ID_POSTFIX = "-param-flow-rules.json";
    public static final String AUTHORITY_DATA_ID_POSTFIX = "-authority-rules.json";
    public static final String DASHBOARD_POSTFIX = "-dashboard";
    public static final String CLUSTER_MAP_DATA_ID_POSTFIX = "-cluster-map";

    /**
     * cc for `cluster-client`
     */
    public static final String CLIENT_CONFIG_DATA_ID_POSTFIX = "-cc-config";
    /**
     * cs for `cluster-server`
     */
    public static final String SERVER_TRANSPORT_CONFIG_DATA_ID_POSTFIX = "-cs-transport-config";
    public static final String SERVER_FLOW_CONFIG_DATA_ID_POSTFIX = "-cs-flow-config";
    public static final String SERVER_NAMESPACE_SET_DATA_ID_POSTFIX = "-cs-namespace-set";


    private NacosConfigUtil() {
    }

    /**
     * 将规则序列化成JSON文本，存储到Nacos server中
     *
     * @param configService nacos config service
     * @param app           应用名称
     * @param postfix       规则后缀 eg.NacosConfigUtil.FLOW_DATA_ID_POSTFIX
     * @param rules         规则对象
     * @throws NacosException 异常
     */
    public static <T> void setRuleStringToNacos(ConfigService configService, String app, String postfix, List<T> rules) throws NacosException {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }

        List<Rule> ruleForApp = rules.stream()
                .map(rule -> {
                    RuleEntity rule1 = (RuleEntity) rule;
                    System.out.println(rule1.getClass());
                    Rule rule2 = rule1.toRule();
                    System.out.println(rule2.getClass());
                    return rule2;
                })
                .collect(Collectors.toList());

        // 存储，给微服务使用
        String dataId = genDataId(app, postfix);
        configService.publishConfig(
                dataId,
                NacosConfigUtil.GROUP_ID,
                JSONUtils.toJSONString(ruleForApp)
        );

        // 存储，给控制台使用
        configService.publishConfig(
                dataId + DASHBOARD_POSTFIX,
                NacosConfigUtil.GROUP_ID,
                JSONUtils.toJSONString(rules)
        );
    }

    /**
     * 从Nacos server中查询响应规则，并将其反序列化成对应Rule实体
     *
     * @param configService nacos config service
     * @param appName       应用名称
     * @param postfix       规则后缀 eg.NacosConfigUtil.FLOW_DATA_ID_POSTFIX
     * @param clazz         类
     * @param <T>           泛型
     * @return 规则对象列表
     * @throws NacosException 异常
     */
    public static <T> List<T> getRuleEntitiesFromNacos(ConfigService configService, String appName, String postfix, Class<T> clazz) throws NacosException {
        String rules = configService.getConfig(
                genDataId(appName, postfix) + DASHBOARD_POSTFIX,
                NacosConfigUtil.GROUP_ID,
                3000
        );
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return JSONUtils.parseObject(clazz, rules);
    }

    private static String genDataId(String appName, String postfix) {
        return appName + postfix;
    }
}