package com.verge.service;

import com.verge.BaseITest;
import com.verge.dto.ManufacturerInfo;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.verge.utiliities.PlayerUtils.getNames;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.equalTo;

public class ManufacturerServiceITest extends BaseITest {

    @Autowired
    private ManufacturerService service;

    @Test
    @FlywayTest
    public void testFindAll() {
        List<ManufacturerInfo> dtos = service.findAll();
        assertThat(dtos.size(), equalTo(13));
        List<String> names = getNames(dtos);
        assertThat(names, containsInAnyOrder("Gibson", "Fender", "Gretsch", "Epiphone", "PRS", "Marshall", "Vox",
                "Orange", "Strymon", "TC Electronic", "Boss", "Dunlop", "Dallas Arbiter"));
    }
}
