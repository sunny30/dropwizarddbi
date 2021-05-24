package io.com.dropwizard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DBEntity {

    private int id;
    private String name;
    private String description;
    private String type;


    public DBEntity(String name,String description,String type){
        this.name = name ;
        this.description = description ;
        this.type = type ;
    }

}
