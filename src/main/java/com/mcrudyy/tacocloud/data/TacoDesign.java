package com.mcrudyy.tacocloud.data;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class TacoDesign {

    private String id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Must be longer then 5")
    private String name;

    @NotNull(message = "Must be bigger then 2 ingredient")
    @Size(min = 2, message = "Must be bigger then 2 ingredient")
    private List<String> ingredients;
}
