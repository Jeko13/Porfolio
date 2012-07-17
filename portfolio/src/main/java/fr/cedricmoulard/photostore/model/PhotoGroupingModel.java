/**
 * 
 */
package fr.cedricmoulard.photostore.model;

import java.util.Comparator;
import java.util.List;

import org.zkoss.zul.GroupsModelArray;

import fr.cedricmoulard.photostore.model.bean.Photo;

/**
 * @author Cedric.MOULARD
 *
 */
public class PhotoGroupingModel extends GroupsModelArray<Photo, String, String, Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6365376439538100753L;

	private static final String footerString = "Total %d items";
    
    private boolean showGroup;
    
    public PhotoGroupingModel(List<Photo> data, Comparator<Photo> cmpr, boolean showGroup) {
        super(data.toArray(new Photo[0]), cmpr);
         
        this.showGroup = showGroup;
    }
 
    @Override
    protected String createGroupHead(Photo[] groupdata, int index, int col) {
        String ret = "";
        if (groupdata.length > 0) {
            ret = groupdata[0].getGallery().getName();
        }
 
        return ret;
    }
 
    @Override
    protected String createGroupFoot(Photo[] groupdata, int index, int col) {
        return String.format(footerString, groupdata.length);
    }
 
    @Override
    public boolean hasGroupfoot(int groupIndex) {
        boolean retBool = false;
         
        if(showGroup) {
            retBool = super.hasGroupfoot(groupIndex);
        }
         
        return retBool;
    }

}
