package ads.graph;

@SuppressWarnings("serial")
public class UnknownTagException extends RuntimeException {

	public UnknownTagException(String tag) {
		super(tag);
	}
}
