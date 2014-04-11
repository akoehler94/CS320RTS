/**
 * 
 */
package edu.ycp.cs320.rts.shared;

/**
 * @author dan
 *
 * Apr 9, 2014
 */
@SuppressWarnings("serial")
public class AttackRequest extends Request {
	private int sourceUnit;
	private int targetUnit;
	
	public AttackRequest(int userId, int source, int target) {
		super(userId);
		setSourceUnit(source);
		setTargetUnit(target);
	}

	/**
	 * @return the sourceUnit
	 */
	public int getSourceUnit() {
		return sourceUnit;
	}

	/**
	 * @param sourceUnit the sourceUnit to set
	 */
	public void setSourceUnit(int sourceUnit) {
		this.sourceUnit = sourceUnit;
	}

	/**
	 * @return the targetUnit
	 */
	public int getTargetUnit() {
		return targetUnit;
	}

	/**
	 * @param targetUnit the targetUnit to set
	 */
	public void setTargetUnit(int targetUnit) {
		this.targetUnit = targetUnit;
	}

}
