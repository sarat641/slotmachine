package slotmachine.web.entities;

import java.io.Serializable;

/**
 *
 * @author SARAT
 */

public class Fileuploads implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String fileName;
    private Integer price;
    private String filelocation;

    public Fileuploads() {
    }

    public Fileuploads(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFilelocation() {
        return filelocation;
    }

    public void setFilelocation(String filelocation) {
        this.filelocation = filelocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fileuploads)) {
            return false;
        }
        Fileuploads other = (Fileuploads) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spittr.web.entities.Fileuploads[ id=" + id + " ]";
    }
    
}
