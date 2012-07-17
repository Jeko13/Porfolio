/**
 * 
 */
package fr.cedricmoulard.photostore.model;

import java.io.Serializable;
import java.util.Comparator;

import org.zkoss.zul.GroupComparator;

import fr.cedricmoulard.photostore.model.bean.Photo;

/**
 * @author Cedric.MOULARD
 *
 */
public class PhotoComparator implements Comparator<Photo>, GroupComparator<Photo>, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5442923541968897269L;

 
    public int compare(Photo o1, Photo o2) {
        return o1.getGallery().getName().compareTo(o2.getGallery().getName().toString());
    }
 
    public int compareGroup(Photo o1, Photo o2) {
        if(o1.getGallery().getName().equals(o2.getGallery().getName()))
            return 0;
        else
            return 1;
    }

}
