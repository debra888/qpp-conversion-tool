package gov.cms.qpp.conversion.api.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DoNotEncrypt;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Model to hold conversion metadata. Maps to a table in DynamoDB.
 */
@DynamoDBTable(tableName = "ConversionMetadata")
public final class Metadata {
	private static final int CPC_PROCESSED_CREATE_DATE_NUM_FIELDS = 2;
	private static final int CPC_PROCESSED_INDEX = 0;
	private static final int CPC_CREATE_DATE_INDEX = 1;

	private String uuid;
	private String tin;  //this field is encrypted
	private String npi;
	private String apm;
	private Long submissionYear;
	private String submissionLocator;
	private String qppLocator;
	private String fileName;  //this field is encrypted
	private Boolean overallStatus;
	private Boolean conversionStatus;
	private Boolean validationStatus;
	private String cpc;
	private String conversionErrorLocator;
	private String validationErrorLocator;
	private String rawValidationErrorLocator;
	private Instant createdDate;
	private Boolean cpcProcessed;
	private Boolean test;

	/**
	 * Constructs a new {@code Metadata} with the {@code createdDate} filled in upon construction.
	 */
	public Metadata() {
		createdDate = Instant.now();
	}


	/**
	 * The UUID that uniquely identifies this item.
	 *
	 * @return The UUID.
	 */
	@DynamoDBHashKey(attributeName = "Uuid")
	@DynamoDBAutoGeneratedKey
	public String getUuid() {
		return uuid;
	}

	/**
	 * There is no reason to set this manually because it is automatically generated when saved to DynamoDB.
	 *
	 * @param uuid The UUID to use.
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * The date and time when this item was created.
	 *
	 * @return The date and time.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "CreateDate")
	@DynamoDBTypeConverted(converter = InstantConverter.class)
	public Instant getCreatedDate() {
		return createdDate;
	}

	/**
	 * There is no reason to set this manually because it is automatically generated when saved to DynamoDB.
	 *
	 * @param createdDate The date and time to use.
	 */
	public void setCreatedDate(Instant createdDate) {
		if (createdDate != null) {
			this.createdDate = createdDate;
		} else {
			this.createdDate = null;
		}
	}

	/**
	 * The TIN associated with the the conversion.
	 *
	 * @return The TIN.
	 */
	@DynamoDBAttribute(attributeName = "Tin")
	public String getTin() {
		return tin;
	}

	/**
	 * Sets the TIN associated with the the conversion.
	 *
	 * @param tin The TIN to use.
	 */
	public void setTin(String tin) {
		this.tin = tin;
	}

	/**
	 * The NPI associated with the the conversion.
	 *
	 * @return The NPI.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "Npi")
	public String getNpi() {
		return npi;
	}

	/**
	 * Sets the NPI associated with the the conversion
	 *
	 * @param npi The NPI to use.
	 */
	public void setNpi(String npi) {
		this.npi = npi;
	}

	/**
	 * The APM Entity ID associated with the the conversion. Used with CPC+.
	 *
	 * @return The APM Entity ID.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "Apm")
	public String getApm() {
		return apm;
	}

	/**
	 * Sets the the APM Entity ID associated with the the conversion. Used with CPC+.
	 *
	 * @param apm The APM Entity ID.
	 */
	public void setApm(String apm) {
		this.apm = apm;
	}

	/**
	 * The submission year associated with the the conversion.
	 *
	 * @return The submission year.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "SubmissionYear")
	public Long getSubmissionYear() {
		return submissionYear;
	}

	/**
	 * Sets the submission year associated with the the conversion
	 *
	 * @param submissionYear The submission year to use.
	 */
	public void setSubmissionYear(Long submissionYear) {
		this.submissionYear = submissionYear;
	}

	/**
	 * A location to where the submitted file can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "SubmissionLocator")
	public String getSubmissionLocator() {
		return submissionLocator;
	}

	/**
	 * Sets a location to where the submitted file can be found.
	 *
	 * @param submissionLocator The location to use.
	 */
	public void setSubmissionLocator(String submissionLocator) {
		this.submissionLocator = submissionLocator;
	}

	/**
	 * A location where the submission QPP can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "QPPLocator")
	public String getQppLocator() {
		return qppLocator;
	}

	/**
	 * Sets a location where the submission QPP can be found.
	 *
	 * @param qppLocator The location to use.
	 */
	public void setQppLocator(String qppLocator) {
		this.qppLocator = qppLocator;
	}

	/**
	 * The file name of the file uploaded to the converter.
	 *
	 * @return The file name.
	 */
	@DynamoDBAttribute(attributeName = "FileName")
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name of the file uploaded to the converter.
	 *
	 * @param fileName The file name to use.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * The success or failure of the conversion and the submission validation.
	 *
	 * @return Success or failure.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "OverallStatus")
	public Boolean getOverallStatus() {
		return overallStatus;
	}

	/**
	 * Sets the overall status of the conversion and submission validation.
	 *
	 * @param overallStatus The overall status to use.
	 */
	public void setOverallStatus(Boolean overallStatus) {
		this.overallStatus = overallStatus;
	}

	/**
	 * Whether a submission was part of a test
	 *
	 * @return Test or valid
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "Test")
	public Boolean getTest() {
		return test;
	}

	/**
	 * Sets whether a submission is part of a test
	 *
	 * @param test Whether a submission is part of a test
	 */
	public void setTest(Boolean test) {
		this.test = test;
	}

	/**
	 * The success or failure of only the conversion.
	 *
	 * @return Success or failure.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ConversionStatus")
	public Boolean getConversionStatus() {
		return conversionStatus;
	}

	/**
	 * Sets the conversion status.
	 *
	 * @param conversionStatus The conversion status to use.
	 */
	public void setConversionStatus(Boolean conversionStatus) {
		this.conversionStatus = conversionStatus;
	}

	/**
	 * The success or failure of only the submission validation.
	 *
	 * @return Success or failure.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ValidationStatus")
	public Boolean getValidationStatus() {
		return validationStatus;
	}

	/**
	 * Sets the submission validation status.
	 *
	 * @param validationStatus The validation status to use.
	 */
	public void setValidationStatus(Boolean validationStatus) {
		this.validationStatus = validationStatus;
	}

	/**
	 * Whether the conversion was for the CPC+ program.
	 *
	 * This is set to a {@link String} that contains "CPC_" plus a number for DynamoDB partitioning of the GSI.
	 * If this method returns {@code null}, this was not a CPC+ conversion.
	 *
	 * @return A {@link String} for a CPC+ conversion, null otherwise.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = Constants.DYNAMO_CPC_ATTRIBUTE)
	public String getCpc() {
		return cpc;
	}

	/**
	 * Sets whether the conversion was for the CPC+ program.
	 *
	 * If not {@code null}, must be of the form "CPC_" plus a number.
	 * Setting this to {@code null}, indicates this was not a CPC+ conversion.
	 *
	 * @param cpc A CPC+ conversion or not.
	 */
	public void setCpc(String cpc) {
		this.cpc = cpc;
	}

	/**
	 * A location to where the conversion error JSON can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ConversionErrorLocator")
	public String getConversionErrorLocator() {
		return conversionErrorLocator;
	}

	/**
	 * Sets a location to where the conversion error JSON can be found.
	 *
	 * @param conversionErrorLocator A location.
	 */
	public void setConversionErrorLocator(String conversionErrorLocator) {
		this.conversionErrorLocator = conversionErrorLocator;
	}

	/**
	 * A location to where the submission validation error JSON can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "ValidationErrorLocator")
	public String getValidationErrorLocator() {
		return validationErrorLocator;
	}

	/**
	 * Sets a location to where the submission validation error JSON can be found.
	 *
	 * @param validationErrorLocator A location.
	 */
	public void setValidationErrorLocator(String validationErrorLocator) {
		this.validationErrorLocator = validationErrorLocator;
	}

	/**
	 * A location to where the raw submission validation error response can be found.
	 *
	 * For example, for AWS, this could be an ARN.
	 *
	 * @return The location.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = "RawValidationErrorLocator")
	public String getRawValidationErrorLocator() {
		return rawValidationErrorLocator;
	}

	/**
	 * Sets a location to where the submission validation error JSON can be found.
	 *
	 * @param rawValidationErrorLocator A location.
	 */
	public void setRawValidationErrorLocator(String rawValidationErrorLocator) {
		this.rawValidationErrorLocator = rawValidationErrorLocator;
	}

	/**
	 * Whether the file was processed by the CPC+ team
	 *
	 * Ignored when writing to DynamoDB because {@code CpcProcessed_CreateDate} holds the pertinent information.
	 *
	 * @return Whether the file was processed.
	 */
	@DynamoDBIgnore
	public Boolean getCpcProcessed() {
		return cpcProcessed;
	}

	/**
	 * Sets whether the file was processed by the CPC+ team
	 *
	 * @param cpcProcessed
	 */
	public void setCpcProcessed(Boolean cpcProcessed) {
		this.cpcProcessed = cpcProcessed;
	}

	/**
	 * Returns an attribute that combines the CPC+ processed state and the date of creation.
	 *
	 * This is mostly useful in the CPC+ global secondary index.
	 *
	 * @return The combined attribute.
	 */
	@DoNotEncrypt
	@DynamoDBAttribute(attributeName = Constants.DYNAMO_CPC_PROCESSED_CREATE_DATE_ATTRIBUTE)
	public String getCpcProcessedCreateDate() {
		String combination = null;

		if (cpcProcessed != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
			combination = cpcProcessed.toString() + "#" + formatter.format(createdDate);
		}

		return combination;
	}

	/**
	 * Sets the separate CPC+ processed flag and created date based on the argument
	 *
	 * Splits the the processed flag from the date by a {@code #} character.
	 * The first field must be {@code true} or {@code false} which represents the CPC+ processed boolean.
	 * The second field must be an ISO 8601 timestamp string.  For example, {@code 2017-12-08T18:32:54.846Z}.
	 *
	 * @param combination The combined attribute.
	 */
	public void setCpcProcessedCreateDate(String combination) {

		String[] split = combination.split("#");

		if (split.length < CPC_PROCESSED_CREATE_DATE_NUM_FIELDS) {
			return;
		}

		String isProcessed = split[CPC_PROCESSED_INDEX];
		String creationDate = split[CPC_CREATE_DATE_INDEX];
		Instant instant = Instant.parse(creationDate);

		setCpcProcessed(Boolean.valueOf(isProcessed));
		setCreatedDate(instant);
	}

	/**
	 * Determines the equality between this object and another.
	 *
	 * @param o The other object.
	 * @return True if equal, false if not equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || o.getClass() != getClass()) {
			return false;
		}

		Metadata that = (Metadata) o;

		boolean equals = Objects.equals(submissionYear, that.submissionYear);
		equals &= Objects.equals(overallStatus, that.overallStatus);
		equals &= Objects.equals(conversionStatus, that.conversionStatus);
		equals &= Objects.equals(validationStatus, that.validationStatus);
		equals &= Objects.equals(cpc, that.cpc);
		equals &= Objects.equals(uuid, that.uuid);
		equals &= Objects.equals(tin, that.tin);
		equals &= Objects.equals(npi, that.npi);
		equals &= Objects.equals(createdDate, that.createdDate);
		equals &= Objects.equals(apm, that.apm);
		equals &= Objects.equals(submissionLocator, that.submissionLocator);
		equals &= Objects.equals(qppLocator, that.qppLocator);
		equals &= Objects.equals(fileName, that.fileName);
		equals &= Objects.equals(conversionErrorLocator, that.conversionErrorLocator);
		equals &= Objects.equals(validationErrorLocator, that.validationErrorLocator);
		equals &= Objects.equals(rawValidationErrorLocator, that.rawValidationErrorLocator);
		equals &= Objects.equals(cpcProcessed, that.cpcProcessed);
		return equals;
	}

	/**
	 * Converter for DynamoDb to convert type {@link Instant} to a {@link String} in the database
	 */
	public static class InstantConverter implements DynamoDBTypeConverter<String, Instant> {
		/**
		 * Converts the an Instant to the ISO INSTANT format string for db storage
		 *
		 * @param date Object to be converted
		 * @return Converted Object
		 */
		@Override
		public String convert(final Instant date) {
			return DateTimeFormatter.ISO_INSTANT.format(date);
		}

		/**
		 * Converts a String to an Instant for application usage
		 *
		 * @param stringValue object to be reverted
		 * @return reverted object
		 */
		@Override
		public Instant unconvert(final String stringValue) {
			return Instant.parse(stringValue);
		}
	}

	/**
	 * Computes and returns the hash code for this object.
	 * @return The hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(uuid, tin, npi, createdDate, apm, submissionYear,
				submissionLocator, qppLocator, fileName, overallStatus, conversionStatus, validationStatus,
				cpc, conversionErrorLocator, validationErrorLocator, rawValidationErrorLocator, cpcProcessed);
	}
}
