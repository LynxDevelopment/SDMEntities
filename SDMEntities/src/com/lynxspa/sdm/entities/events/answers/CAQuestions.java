package com.lynxspa.sdm.entities.events.answers;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.sdm.entities.events.CAEventCollected;

@Entity
@Table(name="TB_CA_QUESTIONS") 
@org.hibernate.annotations.Table(appliesTo="TB_CA_QUESTIONS",indexes={
	@Index(name="IDX_QUESTION_VERSION",columnNames="VERSION"),
	@Index(name="IDX_QUESTION_DELETED",columnNames="ISDELETED"),
	@Index(name="IDX_QUESTION_EVENT",columnNames="FKEVENT")
})
public class CAQuestions implements UpdatableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2946844048987847123L;
	
	private long id = 0l;
	private String text=null;
	private boolean optional=false;
	private int position=0;
	private String format=null;
	private boolean hidden=false;
	private boolean header=false;
	private long headerGroup=0l;
	private int headerPosition=0;
	private int version=0;
	private UpdateAuditor auditor=null;
	private CAAnswerType answerType=null;
	private String description=null;
	private String defaultValue=null;
	private CAEventCollected event=null;
	private List<CAEventHoldingAnswer> eventHoldingAnswer=null;
	
	public CAQuestions() {

	}
	
	@Id
	@SequenceGenerator(name="CAQUESTION_GEN", sequenceName="CAQUESTION_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAQUESTION_GEN")
	@Column(name="ID", nullable=false, updatable=false)	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="TEXT", length=256, nullable=false)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Column(name="ISOPTIONAL", nullable=false)
	public boolean isOptional() {
		return optional;
	}
	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	@Column(name="POSITION", nullable=false)
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	@Column(name="HEADERPOSITION", nullable=false)
	public int getHeaderPosition() {
		return headerPosition;
	}
	public void setHeaderPosition(int headerPosition) {
		this.headerPosition = headerPosition;
	}

	@Column(name="FORMAT", length=64, nullable=true)
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name="ISHIDDEN", nullable=false)
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	@Column(name="ISHEADER", nullable=false)
	public boolean isHeader() {
		return header;
	}
	public void setHeader(boolean header) {
		this.header = header;
	}

	@Column(name="HEADERGROUP", nullable=false)
	public long getHeaderGroup() {
		return headerGroup;
	}
	public void setHeaderGroup(long headerGroup) {
		this.headerGroup = headerGroup;
	}

	
	@Version
	@Column(name="VERSION", nullable=false)
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Embedded
	public UpdateAuditor getAuditor() {
		return auditor;
	}
	public void setAuditor(UpdateAuditor auditor) {
		this.auditor = auditor;
	}

	@ManyToOne(targetEntity = CAAnswerType.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_ANSWERTYPE")
	@JoinColumn(name="FKANSWERTYPE",nullable=true)
	public CAAnswerType getAnswerType() {
		return answerType;
	}
	public void setAnswerType(CAAnswerType answerType) {
		this.answerType = answerType;
	}

	@ManyToOne(targetEntity = CAEventCollected.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_QUESTIONEVENT")
	@JoinColumn(name="FKEVENT",nullable=false)
	public CAEventCollected getEvent() {
		return event;
	}
	public void setEvent(CAEventCollected event) {
		this.event = event;
	}

	@Column(name="DESCRIPTION", length=256,nullable=true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="DEFAULTVALUE", length=256,nullable=true)
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	@OneToMany(targetEntity = CAEventHoldingAnswer.class, mappedBy="question",fetch=FetchType.LAZY)
	public List<CAEventHoldingAnswer> getEventHoldingAnswer() {
		return eventHoldingAnswer;
	}

	public void setEventHoldingAnswer(List<CAEventHoldingAnswer> eventHoldingAnswer) {
		this.eventHoldingAnswer = eventHoldingAnswer;
	}

}
