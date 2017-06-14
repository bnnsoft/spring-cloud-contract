package org.springframework.cloud.contract.verifier.plugin

import org.springframework.cloud.contract.stubrunner.StubConfiguration
import spock.lang.Specification

/**
 * @author Marcin Grzejszczak
 */
class GradleContractsDownloaderSpec extends Specification {

	def "should parse dependency via string notation"() {
		given:
			String stringNotation = "com.example:foo:1.0.0:stubs"
			def dep = new ContractVerifierExtension.Dependency(stringNotation: stringNotation)
		when:
			StubConfiguration stubConfig = new GradleContractsDownloader(null, null).stubConfiguration(dep)
		then:
			stubConfig.groupId == "com.example"
			stubConfig.artifactId == "foo"
			stubConfig.version == "1.0.0"
			stubConfig.classifier == "stubs"
	}
}
