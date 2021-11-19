package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;

    private Map<String, Boolean> columnMap;
    private List<Animal> animalList;

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!";

        columnMap = new HashMap<String, Boolean>() {
            {
                put("COL1", Boolean.TRUE);
                put("COL2", Boolean.FALSE);
                put("COL3", Boolean.TRUE);
            }
        };
        
        animalList = Arrays.asList(
                new Animal("Tiger", "Max", "White"),
                new Animal("Elephant", "Nellie", "Pink"),
                new Animal("Bear", "Balloo", "Brown")
        );
    }
    
    public void toggleColumn(String col) {
        columnMap.put(col, !(columnMap.get(col)));
    }

    
    public Map<String, Boolean> getColumnMap() {
        return columnMap;
    }

    public void setColumnMap(Map<String, Boolean> columnMap) {
        this.columnMap = columnMap;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
    
}
