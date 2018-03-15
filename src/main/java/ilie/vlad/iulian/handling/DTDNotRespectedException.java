package ilie.vlad.iulian.handling;

public class DTDNotRespectedException extends Exception {
	public DTDNotRespectedException() {
		super("Fisierul XML nu respecta structura DTD!");
	}
}
