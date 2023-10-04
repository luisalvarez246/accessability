package com.accessability.accessability.dto;

import com.accessability.accessability.models.Type;
import com.accessability.accessability.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StoreCreateRequest
{
    private Long            id;
    private String          storeName;
    private Type            type;
    private String          city;
    private String          address;
    private String          phone;
    private String          web;
    private String          email;
    private MultipartFile   image;
    private List<Long>      characteristicIds;

    @Override
    public String toString()
    {
        return ("Request " +
                "[storeName=" + storeName + ", " +
                "type=" + type + ", " +
                "city=" + city + ", " +
                "address=" + address + ", " +
                "phone=" + phone + ", " +
                "web=" + web + ", " +
                "email=" + email + ", " +
                "image=" + image + ", " +
                "characteristicIds=" + characteristicIds +"]"
        );
    }
}

