package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.LogTraceConfig;
import hello.proxy.config.v1_proxy.ConcreteProxyConfig;
import hello.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.config.v2_dynamic_proxy.DynamicBasicConfig;
import hello.proxy.config.v2_dynamic_proxy.DynamicFilterConfig;
import hello.proxy.config.v3_proxyfactory.advice.ProxyFactoryConfigV1;
import hello.proxy.config.v3_proxyfactory.advice.ProxyFactoryConfigV2;
import hello.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import hello.proxy.config.v5_autorproxy.AutoProxyConfig;
import hello.proxy.config.v6_aop.AopConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 스프링 부트는 기본적으로 안에 ComponentScan이 있는데 이 클래스 안에 있는 패키지 하위를 전부 스캔합니다.
 * 그래서 버전별로 설정을 다르게 주기 위해 scanBasePackages로 스캔 범위를 지정해주고 @Import로 설정 파일을 등록합니다.
 */
//@Import({AopConfig.class})
//@Import({AutoProxyConfig.class})
// @Import({BeanPostProcessorConfig.class})
//@Import({ProxyFactoryConfigV2.class, LogTraceConfig.class})
//@Import({ProxyFactoryConfigV1.class, LogTraceConfig.class})
@Import(DynamicFilterConfig.class)
//@Import(DynamicBasicConfig.class)
//@Import({ConcreteProxyConfig.class, InterfaceProxyConfig.class})
@SpringBootApplication(scanBasePackages = "hello.proxy.app.v3")
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}
}
