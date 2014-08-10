/**
 * Filter Interface - 
 * Specifies a filter method to modify images
 * 
 * @author Tammy VanDeGrift
 * @version Oct. 31, 2007
 * 
 * !!! DO NOT MODIFY THIS INTERFACE !!!
 */

/** interface filter. All filters should implement this interface */
public interface Filter {
  /**
   * Modify the image according to your algorithm
   * 
   * @param  theImage    The image to modify
   */
  void filter(PixelImage theImage);
}
