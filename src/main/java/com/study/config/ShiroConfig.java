package com.study.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */
@Configuration
public class ShiroConfig {

//	@Autowired(required = false)
//	SysPermissionInitService sysPermissionInitService;

	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.password}")
	private String password;

	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.timeout}")
    private int timeout;

	
//	
//    // CasServerUrlPrefix
//    public static final String casServerUrlPrefix = "https://localhost:8443/cas";
//    // Cas登录页面地址
//    public static final String casLoginUrl = casServerUrlPrefix + "/login";
//    // Cas登出页面地址
//    public static final String casLogoutUrl = casServerUrlPrefix + "/logout";
//    // 当前工程对外提供的服务地址
//    public static final String shiroServerUrlPrefix = "http://localhost:9090/myspringboot";
//    // casFilter UrlPattern
//    public static final String casFilterUrlPattern = "/shiro-cas";
//    // 登录地址
//    public static final String loginUrl = casLoginUrl + "?service=" + shiroServerUrlPrefix + casFilterUrlPattern;
//    /** * 注册DelegatingFilterProxy（Shiro） * * @param dispatcherServlet * @return * @author SHANHY * @create 2016年1月13日 */
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
//        // 该值缺省为false,表示生命周期由SpringApplicationContext管理,设置为true则表示由ServletContainer管理 
//        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
//        filterRegistration.setEnabled(true);
//        filterRegistration.addUrlPatterns("/*");
//        return filterRegistration;
//    }
//
//    @Bean(name = "lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
//        daap.setProxyTargetClass(true);
//        return daap;
//    }
//	
//    @Bean
//    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
//        aasa.setSecurityManager(securityManager);
//        return aasa;
//    }
//    
//    /** CAS过滤器 */
//    @Bean(name = "casFilter")
//    public CasFilter getCasFilter() {
//        CasFilter casFilter = new CasFilter();
//        casFilter.setName("casFilter");
//        casFilter.setEnabled(true);
//        // 登录失败后跳转的URL，也就是 Shiro 执行 CasRealm 的 doGetAuthenticationInfo 方法向CasServer验证tiket
//        casFilter.setFailureUrl(loginUrl);// 我们选择认证失败后再打开登录页面
//        return casFilter;
//    }
    
//	/**
//	 * ShiroFilterFactoryBean 处理拦截资源文件问题。
//	 * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
//	 * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
//	 *
//	 * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
//	 * 3、部分过滤器可指定参数，如perms，roles
//	 *
//	 */
//	@Bean
//	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
//		Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
//		LogoutFilter logoutFilter = new LogoutFilter();
//		logoutFilter.setRedirectUrl("/login");
//		filters.put("logout", logoutFilter);
//		shiroFilterFactoryBean.setFilters(filters);
		
		// 添加cas过滤器
//        Map<String, Filter> filters = new HashMap<>();
//        filters.put("casFilter", getCasFilter());
//        shiroFilterFactoryBean.setFilters(filters);
		
//		Map<String, String> filterChainDefinitionManager = new LinkedHashMap<String, String>();
		// shiro集成cas后，首先添加该规则
//		filterChainDefinitionManager.put(casFilterUrlPattern, "casFilter");
		
//		filterChainDefinitionManager.put("/logout", "logout");
//		filterChainDefinitionManager.put("/login", "anon");
//		
//		filterChainDefinitionManager.put("/static/**", "anon");
//		// 给角色授权可访问的URL
////		filterChainDefinitionManager.put("/userinfo", "roles[admin]");
//		filterChainDefinitionManager.put("/**", "anon");
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
//		
//		shiroFilterFactoryBean.setLoginUrl("/login");
//		shiroFilterFactoryBean.setSuccessUrl("/index");
//		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//		return shiroFilterFactoryBean;
//	}
//
//	@Bean
//	public SecurityManager securityManager() {
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		// 设置realm.
////		securityManager.setRealm(myShiroRealm());
//		List<Realm> realms = new ArrayList<Realm>();
////		realms.add(myShiroRealm());
//		// 单点登录realm
////		realms.add(myShiroCasRealm());
//		securityManager.setRealms(realms);
//		// 自定义缓存实现 使用redis
//		securityManager.setCacheManager(cacheManager());
//		// 自定义session管理 使用redis
//		securityManager.setSessionManager(sessionManager());
//		//注入记住我管理器;
//	    securityManager.setRememberMeManager(rememberMeManager());
//	    // 设置cas对象
////	    securityManager.setSubjectFactory(new CasSubjectFactory());
//		return securityManager;
//	}
//
//	/**
//	 * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
//	 * 
//	 * @return
//	 */
////	@Bean
////	public MyShiroRealm myShiroRealm() {
////		MyShiroRealm myShiroRealm = new MyShiroRealm();
////		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
////		return myShiroRealm;
////	}
////	
////	@Bean
////	public MyShiroCasRealm myShiroCasRealm() {
////		MyShiroCasRealm myShiroCasRealm = new MyShiroCasRealm();
////		return myShiroCasRealm;
////	}
//	
//    /**
//     * 凭证匹配器
//     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
//     *  所以我们需要修改下doGetAuthenticationInfo中的代码;
//     * ）
//     * @return
//     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher(){
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
//        return hashedCredentialsMatcher;
//    }
//
//	/**
//	 * 配置shiro redisManager
//	 * 使用的是shiro-redis开源插件
//	 * @return
//	 */
//	public RedisManager redisManager() {
//		RedisManager redisManager = new RedisManager();
//		redisManager.setHost(host);
//		redisManager.setPort(port);
//		redisManager.setExpire(1800);// 配置缓存过期时间
//		redisManager.setTimeout(timeout);
//		 redisManager.setPassword(password);
//		return redisManager;
//	}
//
//	/**
//	 * cacheManager 缓存 redis实现
//	 * 使用的是shiro-redis开源插件
//	 * @return
//	 */
//	public RedisCacheManager cacheManager() {
//		RedisCacheManager redisCacheManager = new RedisCacheManager();
//		redisCacheManager.setRedisManager(redisManager());
//		return redisCacheManager;
//	}
//
//	/**
//	 * RedisSessionDAO shiro sessionDao层的实现 通过redis
//	 * 使用的是shiro-redis开源插件
//	 */
//	@Bean
//	public RedisSessionDAO redisSessionDAO() {
//		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
//		redisSessionDAO.setRedisManager(redisManager());
//		return redisSessionDAO;
//	}
//
//	/**
//	 * Session Manager
//	 * 使用的是shiro-redis开源插件
//	 */
//	@Bean
//	public DefaultWebSessionManager sessionManager() {
//		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//		sessionManager.setSessionDAO(redisSessionDAO());
//		sessionManager.setGlobalSessionTimeout(1000 * 60 * 30);
//		return sessionManager;
//	}
//	
//	/**
//     * cookie对象;
//     * @return
//     */
//    public SimpleCookie rememberMeCookie(){
//       //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//       SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//       //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//       simpleCookie.setMaxAge(2592000);
//       return simpleCookie;
//    }
//    
//    /**
//     * cookie管理对象;记住我功能
//     * @return
//     */
//    public CookieRememberMeManager rememberMeManager(){
//       CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//       cookieRememberMeManager.setCookie(rememberMeCookie());
//       //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//       cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
//       return cookieRememberMeManager;
//    }
//    
////    /**
////     * 限制同一账号登录同时登录人数控制
////     * @return
////     */
////    public KickoutSessionControlFilter kickoutSessionControlFilter(){
////    	KickoutSessionControlFilter kickoutSessionControlFilter = new KickoutSessionControlFilter();
////    	//使用cacheManager获取相应的cache来缓存用户登录的会话；用于保存用户—会话之间的关系的；
////    	//这里我们还是用之前shiro使用的redisManager()实现的cacheManager()缓存管理
////    	//也可以重新另写一个，重新配置缓存时间之类的自定义缓存属性
////    	kickoutSessionControlFilter.setCacheManager(cacheManager());
////    	//用于根据会话ID，获取会话进行踢出操作的；
////    	kickoutSessionControlFilter.setSessionManager(sessionManager());
////    	//是否踢出后来登录的，默认是false；即后者登录的用户踢出前者登录的用户；踢出顺序。
////    	kickoutSessionControlFilter.setKickoutAfter(false);
////    	//同一个用户最大的会话数，默认1；比如2的意思是同一个用户允许最多同时两个人登录；
////    	kickoutSessionControlFilter.setMaxSession(1);
////    	//被踢出后重定向到的地址；
////    	kickoutSessionControlFilter.setKickoutUrl("/kickout");
////        return kickoutSessionControlFilter;
////     }
}
