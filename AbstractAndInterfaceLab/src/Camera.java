
abstract class Camera {
	private  String lensType = "Standard";
	private  Integer focusRange = 5;
	
	public abstract void focus(Integer feet);
	
	public abstract void record();
	
	public  String getLensType() {
		return lensType;
	}

	//method for passing in String lens type
	public  void setLensType(String lensType) {
		lensType = lensType;
	}

	//getter for FocusRange
	public  int getFocusRange() {
		return focusRange;
	}

	//method for passing in int and setting FocusRange
	public void setFocusRange(int focusRange) {
		focusRange = focusRange;
	}
}
