import java.io.Serializable;

public class Attestation implements Serializable, Cloneable, Comparable<Attestation>{
	private double firstAttestationPoints;
	private double secondAttestationPoints;
	private double finalAttestationPoints;
	private Mark totalAttestation;
	public Attestation(){
		firstAttestationPoints = 0.0;
		secondAttestationPoints = 0.0;
		finalAttestationPoints = 0.0;
		totalAttestation = null;
	}

	public double getFirstAttestationPoints() {
		return firstAttestationPoints;
	}
	
	public void addPointToFirstAttestation(double points) {
		firstAttestationPoints += points;
	}
	
	public double getSecondAttestationPoints() {
		return secondAttestationPoints;
	}
	public void addPointToSecondAttestation(double points) {
		secondAttestationPoints+=points;
	}
	public double getFinalPoints() {
		return finalAttestationPoints;
	}
	
	public void setFinalPoints(double finalAttestationPoints) {
		this.finalAttestationPoints = finalAttestationPoints;
		totalAttestation = getTotalAttestation();
	}
	public Mark getTotalAttestation() {
		double finalPoints = getFirstAttestationPoints() + getSecondAttestationPoints() + getFinalPoints();
		totalAttestation = new Mark(finalPoints);
		return totalAttestation;
	}
	public int hashCode() {
		int result = 17;
		result += 31*firstAttestationPoints;
		result +=31*secondAttestationPoints;
		result += 31*finalAttestationPoints;
		return result;
	}
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(!(o instanceof Attestation))
			return false;
		Attestation attestation = (Attestation)o;
		return this.firstAttestationPoints == attestation.firstAttestationPoints
				&& this.secondAttestationPoints == attestation.secondAttestationPoints
				&& this.finalAttestationPoints == attestation.finalAttestationPoints;
	}
	public Object clone() throws CloneNotSupportedException {
		Attestation attestation = (Attestation)super.clone();
		attestation.totalAttestation = (Mark)this.totalAttestation.clone();
		return attestation;
	}
	@Override
	public int compareTo(Attestation o) {
		return totalAttestation.compareTo(o.totalAttestation);
	}
	public String toString() {
		return  "First Attestation " + getFirstAttestationPoints() + " Second Attestation " + getSecondAttestationPoints()  + " Final " + getFinalPoints();
	}
	
}
