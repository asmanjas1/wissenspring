package wjava.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "trainingmaterial")
public class TrainingMaterialEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String questiontitle;
	
	private String topic;
	
	private String technology;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationdate;
	
	private String ans;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestiontitle() {
		return questiontitle;
	}

	public void setQuestiontitle(String questiontitle) {
		this.questiontitle = questiontitle;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
	
}
