/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author qa
 */
public class Portfolios {

    private int id;
    private String title;
    private String characteristic1;
    private String characteristic2;
    private String description;
    private Boolean deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCharacteristic1() {
        return characteristic1;
    }

    public void setCharacteristic1(String characteristic1) {
        this.characteristic1 = characteristic1;
    }

    public String getCharacteristic2() {
        return characteristic2;
    }

    public void setCharacteristic2(String characteristic2) {
        this.characteristic2 = characteristic2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
