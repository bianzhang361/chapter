package com.smart.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/5/9.
 */
@Entity
@Table(name = "t_view_point")
public class ViewPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    protected int pointId;

    @Column(name = "point_name")
    protected String pointName;

    @Column(name = "ticket_price")
    protected float ticketPrice;

    @Column(name = "description")
    protected String description;

    @Column(name = "img_file")
    protected byte[] imgFile;

    @ManyToOne
    @Column(name = "space_id")
    protected ViewSpace viewSpace = new ViewSpace();

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImgFile() {
        return imgFile;
    }

    public void setImgFile(byte[] imgFile) {
        this.imgFile = imgFile;
    }

    public ViewSpace getViewSpace() {
        return viewSpace;
    }

    public void setViewSpace(ViewSpace viewSpace) {
        this.viewSpace = viewSpace;
    }
}
