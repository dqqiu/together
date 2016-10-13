/**
 * @description : web测试基类,@WebIntegrationTest("server.port:0")表示启动时使用随机端口
 * @author      : qiudequan
 * @path        : org.spirit.framework.boot.test.base.BaseWebTest
 * when                     who                  what
 * --------------------------------------------------------
 * 2016年10月13日					qiudequan			 create
 */
package org.spirit.framework.boot.test.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest("server.port:0")	//由于是Web测试，需要有服务端口，server.port:0表示使用随机端口
@ActiveProfiles("unit")				//使用unit配置
public class BaseWebTest {
	@Autowired
    protected WebApplicationContext context;
	
	@Autowired
	CharacterEncodingFilter filter;
	
	protected MockMvc mockMvc;
	
	@Before
    public void setupMockMvc() {
		// 向mockMvc中注册WebApplicationContext并添加编码过滤器
        mockMvc = MockMvcBuilders.webAppContextSetup(context).addFilter(this.filter).build();
    }
	
}
