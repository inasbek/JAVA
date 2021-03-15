/**
 * 
 */
package competition;

import java.util.Objects;

/**
 * @author bairouk,Bekkouche
 *
 */

/**
 * Creates a Competitor .
 */
public class Competitor {
	
	private String name;
	private int points;
	
	/**
	* Constructs a competitor .
	* @param name The name of the competitor .
	* @param points The points of the competitor .
	*
	*/
	public Competitor(String name,int points) {
		this.name = name;
		this.points = points;
	}
	
	/**
	* Constructs a competitor .
	* @param name The name of the competitor .
	*/
	public Competitor(String name) {
		this.name = name;
		this.points = 0;
	}
	
	/**
	* Gets the competitor's name.
	* @return name the name of the player
	*
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Gets the competitor's points.
	*@return the points of the player
	*/
	public int getPoints() {
		return points;
	}

	/**
	* Adds points to a competitor.
	*@param point The points to add .
	*/
	public void addPoints(int point) {
		this.points += point ;
	}
	
	/**
	* Set points to a competitor.
	*@param point The points to add .
	*/
	public void setPoints(int point) {
		this.points = point ;
	}
	
	/** 
	  * Returns True if two competitors are equals false else
	 * @return True if two competitors are equals false else
	 * @param obj an object that will be cast and compare to a compititor
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Competitor)) {
			return false;
		}
		Competitor other = (Competitor) obj;
		return Objects.equals(name, other.name) && points == other.points;
	}
	
}
