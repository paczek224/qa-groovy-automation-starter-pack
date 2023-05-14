package com.github.paczek9000.demo

import com.github.paczek9000.tests.BaseTest

class DemoTest extends BaseTest{

    def "Demo groovy and spring test"() {
        given:
        demoPage.goTo()

        when:
        def demoPageTitle = demoPage.getTitle().getText()

        then:
        demoPageTitle.equals("Demo fail")
    }
}
