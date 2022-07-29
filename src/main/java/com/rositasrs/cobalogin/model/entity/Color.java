package com.rositasrs.cobalogin.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_color")
public class Color {
  @Id
  @Column(name = "color_id")
  private String colorId;
  @Column(name = "color_description")
  private String colorDescription;

  public String getColorId() {
    return colorId;
  }

  public void setColorId(String colorId) {
    this.colorId = colorId;
  }

  public String getColorDescription() {
    return colorDescription;
  }

  public void setColorDescription(String colorDescription) {
    this.colorDescription = colorDescription;
  }
}

