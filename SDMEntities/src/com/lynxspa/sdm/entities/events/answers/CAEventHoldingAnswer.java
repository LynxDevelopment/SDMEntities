package com.lynxspa.sdm.entities.events.answers;

import java.util.HashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.lynxspa.entities.UpdatableAdapter;
import com.lynxspa.entities.UpdateAuditor;
import com.lynxspa.entities.securities.SPSecurityPortfolio;


@Entity
@Table(name="TB_CA_EVENTHOLDINGANSWER") 
@org.hibernate.annotations.Table(appliesTo="TB_CA_EVENTHOLDINGANSWER",indexes={
	@Index(name="IDX_EVHOLANSW_VERSION",columnNames="VERSION"),
	@Index(name="IDX_EVHOLANSW_DELETED",columnNames="ISDELETED")
})
public class CAEventHoldingAnswer implements UpdatableAdapter {

	private long id=0l;
	private HashMap<String, Object> dynamicTable=null;
	private int version=0;
	private UpdateAuditor auditor=null;
	private SPSecurityPortfolio holding=null;
	private CAQuestions question=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2661221844707690788L;

	public CAEventHoldingAnswer(){
	}
	
	public CAEventHoldingAnswer (String _user, CAQuestions _question, SPSecurityPortfolio _holding){
		this(_user, _question, _holding, null);
	}
	
	public CAEventHoldingAnswer (String _user, CAQuestions _question, SPSecurityPortfolio _holding, HashMap<String, Object> _dynamicTable){
		super();
		question 	= _question;
		holding 		= _holding;
		dynamicTable	= _dynamicTable;
		this.auditor	= new UpdateAuditor(_user);
	}
	
	@Id
	@SequenceGenerator(name="CAEVENTHOLDINGANSWER_GEN", sequenceName="CAEVENTHOLDINGANSWER_GEN", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CAEVENTHOLDINGANSWER_GEN")
	@Column(name="ID", nullable=false, updatable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Type(type="com.lynxspa.hbt.custom.types.MultipleDynamicTable",parameters={@Parameter(name="elementsPerType",value="10")})
	@Columns(columns={
		@Column(name="BOOLEAN1",nullable=true),
		@Column(name="BOOLEAN2",nullable=true),
		@Column(name="BOOLEAN3",nullable=true),
		@Column(name="BOOLEAN4",nullable=true),
		@Column(name="BOOLEAN5",nullable=true),
		@Column(name="BOOLEAN6",nullable=true),
		@Column(name="BOOLEAN7",nullable=true),
		@Column(name="BOOLEAN8",nullable=true),
		@Column(name="BOOLEAN9",nullable=true),
		@Column(name="BOOLEAN10",nullable=true),
		
		@Column(name="LONG1",nullable=true),
		@Column(name="LONG2",nullable=true),
		@Column(name="LONG3",nullable=true),
		@Column(name="LONG4",nullable=true),
		@Column(name="LONG5",nullable=true),
		@Column(name="LONG6",nullable=true),
		@Column(name="LONG7",nullable=true),
		@Column(name="LONG8",nullable=true),
		@Column(name="LONG9",nullable=true),
		@Column(name="LONG10",nullable=true),
		
		@Column(name="DOUBLE1",nullable=true),
		@Column(name="DOUBLE2",nullable=true),
		@Column(name="DOUBLE3",nullable=true),
		@Column(name="DOUBLE4",nullable=true),
		@Column(name="DOUBLE5",nullable=true),
		@Column(name="DOUBLE6",nullable=true),
		@Column(name="DOUBLE7",nullable=true),
		@Column(name="DOUBLE8",nullable=true),
		@Column(name="DOUBLE9",nullable=true),
		@Column(name="DOUBLE10",nullable=true),
		
		@Column(name="TIMESTAMP1",nullable=true),
		@Column(name="TIMESTAMP2",nullable=true),
		@Column(name="TIMESTAMP3",nullable=true),
		@Column(name="TIMESTAMP4",nullable=true),
		@Column(name="TIMESTAMP5",nullable=true),
		@Column(name="TIMESTAMP6",nullable=true),
		@Column(name="TIMESTAMP7",nullable=true),
		@Column(name="TIMESTAMP8",nullable=true),
		@Column(name="TIMESTAMP9",nullable=true),
		@Column(name="TIMESTAMP10",nullable=true),
		
		@Column(name="SHORTSTRING1", length=16, nullable=true),
		@Column(name="SHORTSTRING2", length=16, nullable=true),
		@Column(name="SHORTSTRING3", length=16, nullable=true),
		@Column(name="SHORTSTRING4", length=16, nullable=true),
		@Column(name="SHORTSTRING5", length=16, nullable=true),
		@Column(name="SHORTSTRING6", length=16, nullable=true),
		@Column(name="SHORTSTRING7", length=16, nullable=true),
		@Column(name="SHORTSTRING8", length=16, nullable=true),
		@Column(name="SHORTSTRING9", length=16, nullable=true),
		@Column(name="SHORTSTRING10", length=16, nullable=true),
		
		@Column(name="MIDDLESTRING1", length=64, nullable=true),
		@Column(name="MIDDLESTRING2", length=64, nullable=true),
		@Column(name="MIDDLESTRING3", length=64, nullable=true),
		@Column(name="MIDDLESTRING4", length=64, nullable=true),
		@Column(name="MIDDLESTRING5", length=64, nullable=true),
		@Column(name="MIDDLESTRING6", length=64, nullable=true),
		@Column(name="MIDDLESTRING7", length=64, nullable=true),
		@Column(name="MIDDLESTRING8", length=64, nullable=true),
		@Column(name="MIDDLESTRING9", length=64, nullable=true),
		@Column(name="MIDDLESTRING10", length=64, nullable=true),
		
		@Column(name="LONGSTRING1", length=128, nullable=true),
		@Column(name="LONGSTRING2", length=128, nullable=true),
		@Column(name="LONGSTRING3", length=128, nullable=true),
		@Column(name="LONGSTRING4", length=128, nullable=true),
		@Column(name="LONGSTRING5", length=128, nullable=true),
		@Column(name="LONGSTRING6", length=128, nullable=true),
		@Column(name="LONGSTRING7", length=128, nullable=true),
		@Column(name="LONGSTRING8", length=128, nullable=true),
		@Column(name="LONGSTRING9", length=128, nullable=true),
		@Column(name="LONGSTRING10", length=128, nullable=true),
		
		@Column(name="CHAR1", length=1, nullable=true),
		@Column(name="CHAR2", length=1, nullable=true),
		@Column(name="CHAR3", length=1, nullable=true),
		@Column(name="CHAR4", length=1, nullable=true),
		@Column(name="CHAR5", length=1, nullable=true),
		@Column(name="CHAR6", length=1, nullable=true),
		@Column(name="CHAR7", length=1, nullable=true),
		@Column(name="CHAR8", length=1, nullable=true),
		@Column(name="CHAR9", length=1, nullable=true),
		@Column(name="CHAR10", length=1, nullable=true),
		
		@Column(name="VERYLONGSTRING1", length=256, nullable=true),
		@Column(name="VERYLONGSTRING2", length=256, nullable=true),
		@Column(name="VERYLONGSTRING3", length=256, nullable=true),
		@Column(name="VERYLONGSTRING4", length=256, nullable=true),
		@Column(name="VERYLONGSTRING5", length=256, nullable=true),
		@Column(name="VERYLONGSTRING6", length=256, nullable=true),
		@Column(name="VERYLONGSTRING7", length=256, nullable=true),
		@Column(name="VERYLONGSTRING8", length=256, nullable=true),
		@Column(name="VERYLONGSTRING9", length=256, nullable=true),
		@Column(name="VERYLONGSTRING10", length=256, nullable=true)
		
		
	})
	@Basic(fetch = FetchType.EAGER)
	public HashMap<String, Object> getDynamicTable() {
		return dynamicTable;
	}
	public void setDynamicTable(HashMap<String, Object> _dynamicTable) {
		this.dynamicTable = _dynamicTable;
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
	
	@ManyToOne(targetEntity = SPSecurityPortfolio.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_HOLDING")
	@JoinColumn(name="FKHOLDING",nullable=false)
	public SPSecurityPortfolio getHolding() {
		return holding;
	}
	public void setHolding(SPSecurityPortfolio holding) {
		this.holding = holding;
	}
	
	
	@ManyToOne(targetEntity = CAQuestions.class,fetch=FetchType.EAGER)
	@ForeignKey(name="FK_QUESTION")
	@JoinColumn(name="FKQUESTION",nullable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	public CAQuestions getQuestion() {
		return question;
	}
	public void setQuestion(CAQuestions question) {
		this.question = question;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
