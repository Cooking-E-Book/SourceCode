package help;

public class FAQ {
	private Question question;
	private Answer answer;
	
	public FAQ(Question question, Answer answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public Answer getAnswer() {
		return answer;
	}
}
