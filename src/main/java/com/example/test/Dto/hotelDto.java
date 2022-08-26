package com.example.test.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class hotelDto {

    private String code;
    private String designation;
    private String representant;
    private String email;
    private String tel;
    private String siteWeb;
    private String debutS;
    private String finS;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getRepresentant() {
        return representant;
    }
    public void setRepresentant(String representant) {
        this.representant = representant;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getSiteWeb() {
        return siteWeb;
    }
    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }
    public String getDebutS() {
        return debutS;
    }
    public void setDebutS(String debutS) {
        this.debutS = debutS;
    }
    public String getFinS() {
        return finS;
    }
    public void setFinS(String finS) {
        this.finS = finS;
    }
}
