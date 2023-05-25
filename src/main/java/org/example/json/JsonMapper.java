package org.example.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.IpLocation;
import org.example.entity.SheduleDto;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonMapper {

    public List<SheduleDto> getShedulesDtos() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<SheduleDto> result = null;
        try {
            result = mapper.readValue("{\n" +
                    "            \"weekDay\": 1,\n" +


                    "            \"dayOff\": \"false\"\n" +
                    "        }, {\n" +
                    "            \"weekDay\": 2,\n" +

                    "            \"closeTime\": \"22:00:00\",\n" +
                    "            \"dayOff\": \"false\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"weekDay\": 3,\n" +
                    "            \"openTime\": \"10:00:00\",\n" +
                    "            \"closeTime\": \"22:00:00\",\n" +
                    "            \"dayOff\": \"false\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"weekDay\": 4,\n" +
                    "            \"openTime\": \"10:00:00\",\n" +
                    "            \"closeTime\": \"22:00:00\",\n" +
                    "            \"dayOff\": \"false\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"weekDay\": 5,\n" +
                    "            \"openTime\": \"11:00:00\",\n" +
                    "            \"closeTime\": \"21:00:00\",\n" +
                    "            \"dayOff\": \"false\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"weekDay\": 6,\n" +
                    "            \"openTime\": null,\n" +
                    "            \"closeTime\": null,\n" +
                    "            \"dayOff\": \"true\"\n" +
                    "        }, {\n" +
                    "            \"weekDay\": 7,\n" +
                    "            \"openTime\": null,\n" +
                    "            \"closeTime\": null,\n" +
                    "            \"dayOff\": \"true\"\n" +
                    "        }", new TypeReference<>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public IpLocation getIpLocationFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        IpLocation location;
        try {
            location = mapper.readValue("{\n" +
                    "  \"postal_code\": \"350000\",\n" +
                    "  \"country\": \"Россия\",\n" +
                    "  \"country_iso_code\": \"RU\",\n" +
                    "  \"federal_district\": \"Южный\",\n" +
                    "  \"region_fias_id\": \"d00e1013-16bd-4c09-b3d5-3cb09fc54bd8\",\n" +
                    "  \"region_kladr_id\": \"2300000000000\",\n" +
                    "  \"region_iso_code\": \"RU-KDA\",\n" +
                    "  \"region_with_type\": \"Краснодарский край\",\n" +
                    "  \"region_type\": \"край\",\n" +
                    "  \"region_type_full\": \"край\",\n" +
                    "  \"region\": \"Краснодарский\",\n" +
                    "  \"area_fias_id\": null,\n" +
                    "  \"area_kladr_id\": null,\n" +
                    "  \"area_with_type\": null,\n" +
                    "  \"area_type\": null,\n" +
                    "  \"area_type_full\": null,\n" +
                    "  \"area\": null,\n" +
                    "  \"city_fias_id\": \"7dfa745e-aa19-4688-b121-b655c11e482f\",\n" +
                    "  \"city_kladr_id\": \"2300000100000\",\n" +
                    "  \"city_with_type\": \"г Краснодар\",\n" +
                    "  \"city_type\": \"г\",\n" +
                    "  \"city_type_full\": \"город\",\n" +
                    "  \"city\": \"Краснодар\",\n" +
                    "  \"city_area\": null,\n" +
                    "  \"city_district_fias_id\": null,\n" +
                    "  \"city_district_kladr_id\": null,\n" +
                    "  \"city_district_with_type\": null,\n" +
                    "  \"city_district_type\": null,\n" +
                    "  \"city_district_type_full\": null,\n" +
                    "  \"city_district\": null,\n" +
                    "  \"settlement_fias_id\": null,\n" +
                    "  \"settlement_kladr_id\": null,\n" +
                    "  \"settlement_with_type\": null,\n" +
                    "  \"settlement_type\": null,\n" +
                    "  \"settlement_type_full\": null,\n" +
                    "  \"settlement\": null,\n" +
                    "  \"street_fias_id\": null,\n" +
                    "  \"street_kladr_id\": null,\n" +
                    "  \"street_with_type\": null,\n" +
                    "  \"street_type\": null,\n" +
                    "  \"street_type_full\": null,\n" +
                    "  \"street\": null,\n" +
                    "  \"stead_fias_id\": null,\n" +
                    "  \"stead_cadnum\": null,\n" +
                    "  \"stead_type\": null,\n" +
                    "  \"stead_type_full\": null,\n" +
                    "  \"stead\": null,\n" +
                    "  \"house_fias_id\": null,\n" +
                    "  \"house_kladr_id\": null,\n" +
                    "  \"house_cadnum\": null,\n" +
                    "  \"house_type\": null,\n" +
                    "  \"house_type_full\": null,\n" +
                    "  \"house\": null,\n" +
                    "  \"block_type\": null,\n" +
                    "  \"block_type_full\": null,\n" +
                    "  \"block\": null,\n" +
                    "  \"entrance\": null,\n" +
                    "  \"floor\": null,\n" +
                    "  \"flat_fias_id\": null,\n" +
                    "  \"flat_cadnum\": null,\n" +
                    "  \"flat_type\": null,\n" +
                    "  \"flat_type_full\": null,\n" +
                    "  \"flat\": null,\n" +
                    "  \"flat_area\": null,\n" +
                    "  \"square_meter_price\": null,\n" +
                    "  \"flat_price\": null,\n" +
                    "  \"room_fias_id\": null,\n" +
                    "  \"room_cadnum\": null,\n" +
                    "  \"room_type\": null,\n" +
                    "  \"room_type_full\": null,\n" +
                    "  \"room\": null,\n" +
                    "  \"postal_box\": null,\n" +
                    "  \"fias_id\": \"7dfa745e-aa19-4688-b121-b655c11e482f\",\n" +
                    "  \"fias_code\": null,\n" +
                    "  \"fias_level\": \"4\",\n" +
                    "  \"fias_actuality_state\": \"0\",\n" +
                    "  \"kladr_id\": \"2300000100000\",\n" +
                    "  \"geoname_id\": \"542420\",\n" +
                    "  \"capital_marker\": \"2\",\n" +
                    "  \"okato\": \"03401000000\",\n" +
                    "  \"oktmo\": \"03701000001\",\n" +
                    "  \"tax_office\": \"2300\",\n" +
                    "  \"tax_office_legal\": \"2300\",\n" +
                    "  \"timezone\": \"UTC+3\",\n" +
                    "  \"geo_lat\": \"45.040216\",\n" +
                    "  \"geo_lon\": \"38.975996\",\n" +
                    "  \"beltway_hit\": null,\n" +
                    "  \"beltway_distance\": null,\n" +
                    "  \"metro\": null,\n" +
                    "  \"divisions\": null,\n" +
                    "  \"qc_geo\": \"4\",\n" +
                    "  \"qc_complete\": null,\n" +
                    "  \"qc_house\": null,\n" +
                    "  \"history_values\": null,\n" +
                    "  \"unparsed_parts\": null,\n" +
                    "  \"source\": null,\n" +
                    "  \"qc\": null,\n" +
                    "  \"date\": \"12:00:00\",\n" +
                    "  \"shedule\": [{\n" +
                    "    \"weekDay\": 1,\n" +
                    "    \"openTime\": \"10:00:00\",\n" +
                    "    \"closeTime\": \"22:00:00\",\n" +
                    "    \"dayOff\": \"false\"\n" +
                    "  }, {\n" +
                    "    \"weekDay\": 2,\n" +
                    "    \"openTime\": \"10:00:00\",\n" +
                    "    \"closeTime\": \"22:00:00\",\n" +
                    "    \"dayOff\": \"false\"\n" +
                    "  },\n" +
                    "    {\n" +
                    "      \"weekDay\": 3,\n" +
                    "      \"openTime\": \"10:00:00\",\n" +
                    "      \"closeTime\": \"22:00:00\",\n" +
                    "      \"dayOff\": \"false\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"weekDay\": 4,\n" +
                    "      \"openTime\": \"10:00:00\",\n" +
                    "      \"closeTime\": \"22:00:00\",\n" +
                    "      \"dayOff\": \"false\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"weekDay\": 5,\n" +
                    "      \"openTime\": \"11:00:00\",\n" +
                    "      \"closeTime\": \"21:00:00\",\n" +
                    "      \"dayOff\": \"false\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"weekDay\": 6,\n" +
                    "      \"openTime\": null,\n" +
                    "      \"closeTime\": null,\n" +
                    "      \"dayOff\": \"true\"\n" +
                    "    }, {\n" +
                    "      \"weekDay\": 7,\n" +
                    "      \"openTime\": null,\n" +
                    "      \"closeTime\": null,\n" +
                    "      \"dayOff\": \"true\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}", IpLocation.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return location;
    }
}
