/**
 * @description : 测试专用配置类
 * @author      : qiudequan
 * @path        : org.spirit.framework.boot.test.profile.TestProfile
 * when                     who                  what
 * --------------------------------------------------------
 * 2016年10月13日					qiudequan			 create
 */
package org.spirit.framework.boot.test.profile;

import org.jmock.auto.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.support.StandardServletEnvironment;

@Profile(value = "unit")
@Configuration   		// 定义为配置类
public class TestProfile {
	@Mock
	StandardServletEnvironment env;
	
	public TestProfile() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Bean
	public StandardServletEnvironment getStandardServletEnvironment() {
		return env;
	}
}
