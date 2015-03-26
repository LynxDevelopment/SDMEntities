package com.lynxspa.sdm.processors.normalize.utils;

import org.apache.log4j.Logger;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;

/**
 * Class to parse SwiftMessages for SDM product
 *
 */
public class SDMSwiftParser {
	
	private String msg; 					// Swift message as String format
	private SwiftMessage swiftMessage; 		// Swift message as WIFE Object
	private static final Logger logger = Logger.getLogger(SDMSwiftParser.class);
	
	/**
	 * Constructor for Swift parser
	 * 
	 * @param msg Swift message in String format
	 * @throws Exception if we can not parse the swift message
	 */
	public SDMSwiftParser(String msg) throws Exception{
		super();
		this.msg = msg;
		this.swiftMessage = getSwiftMessage(this.msg);
	}
	
	/**
	 * Function to get specific value from qualifier in 16R subBlock
	 * @param blockName The name of the 16R subBlock
	 * @param tagName The name of the Tag
	 * @param qualifier The specific qualifier without slashes.
	 * @return Complete String value of the tag
	 */
	public String getStringValueFromTagQualifier(String blockName,String tagName,String qualifier){
		String reply = null;
		Tag[] tags = getTagsFromSubBlock4(blockName,tagName);
		for(Tag tag : tags){
			if(tag.getValue().startsWith(getFullQualifier(qualifier))){
				reply = tag.getValue();
				break;
			}
		}
		return reply;
	}
	/**
	 * Function to get specific value from qualifier in 16R subBlock without any qualifier
	 * @param blockName The name of the 16R subBlock
	 * @param tagName tagName The name of the Tag
	 * @return Complete String value of the tag
	 */
	public String getStringValueFromTagName(String blockName,String tagName){
		SwiftTagListBlock subBlock = this.swiftMessage.getBlock4().getSubBlock(blockName);
		return subBlock.getTagValue(tagName);
	}
	
	/**
	 * Private function to parse Swift message from String format
	 * @param msg The swift message 
	 * @return SwiftMessage object
	 * @throws Exception if we can not parse the swift message
	 */
	private SwiftMessage getSwiftMessage(String msg) throws Exception{
		SwiftMessage message = null;
		try{
			SwiftParser parser = new SwiftParser(msg);
			message=parser.message();
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw e;
		}
		return message;
	}
	
	/**
	 * Private function to get all tags from swift block4 contained in subBlock 16R defined by "blockName" and the name of tag.
	 * @param blockName The name or identifier of suBblock 16R
	 * @param tagName The tag name
	 * @return Tag[]
	 */
	private Tag[] getTagsFromSubBlock4(String blockName,String tagName){
		SwiftTagListBlock subBlock = this.swiftMessage.getBlock4().getSubBlock(blockName);
		return subBlock.getTagsByName(tagName);
	}
	
	/**
	 * Private function to get full qualifier.
	 * @param qualifier String qualifier in Human readable format
	 * @return String qualifier in ISO format.
	 */
	private String getFullQualifier(String qualifier){
		return new StringBuilder().append(":").append(qualifier).append("//").toString();
	}
}
