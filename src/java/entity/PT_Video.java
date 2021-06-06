/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class PT_Video {
    private int pt_video_id ; 
    private int  pt_id ;
    private String pt_video_name ; 
    private String pt_video_link ; 
    
    public PT_Video(){
        
    }

    public PT_Video(int pt_video_id, int pt_id, String pt_video_name, String pt_video_link) {
        this.pt_video_id = pt_video_id;
        this.pt_id = pt_id;
        this.pt_video_name = pt_video_name;
        this.pt_video_link = pt_video_link;
    }

    public int getPt_video_id() {
        return pt_video_id;
    }

    public void setPt_video_id(int pt_video_id) {
        this.pt_video_id = pt_video_id;
    }

    public int getPt_id() {
        return pt_id;
    }

    public void setPt_id(int pt_id) {
        this.pt_id = pt_id;
    }

    public String getPt_video_name() {
        return pt_video_name;
    }

    public void setPt_video_name(String pt_video_name) {
        this.pt_video_name = pt_video_name;
    }

    public String getPt_video_link() {
        return pt_video_link;
    }

    public void setPt_video_link(String pt_video_link) {
        this.pt_video_link = pt_video_link;
    }
}
