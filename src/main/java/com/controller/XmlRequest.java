
package com.controller;

/**
 *
 * @author Edgar Giovanni Hurtarte
 */
public class XmlRequest {
        
        String xmlRequestGetAccountDetail(String msisdn, String date, String sequence, String originHostName){   
        String stringGetBalance = "<methodCall>\n" +
        "   <methodName>GetAccountDetails</methodName>\n" +
        "   <params>\n" +
        "      <param>\n" +
        "         <value>\n" +
        "            <struct>\n" +
        "               <member>\n" +
        "                  <name>originNodeType</name>\n" +
        "                  <value>\n" +
        "                     <string>AIR</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originHostName</name>\n" +
        "                  <value>\n" +
        "                     <string>"+originHostName+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originTransactionID</name>\n" +
        "                  <value>\n" +
        "                     <string>"+sequence+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originTimeStamp</name>\n" +
        "                  <value>\n" +
        "                     <dateTime.iso8601>"+date+"</dateTime.iso8601>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>subscriberNumber</name>\n" +
        "                  <value>\n" +
        "                     <string>"+msisdn+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "            </struct>\n" +
        "         </value>\n" +
        "      </param>\n" +
        "   </params>\n" +
        "</methodCall>";        
        return stringGetBalance;
    }

        String xmlRequestGetAccountDetail2(String msisdn, String date, String sequence, String originHostName){   
        String stringGetBalance = "<methodCall>\n" +
                "   <methodName>GetAccountDetails</methodName>\n" +
                "   <params>\n" +
                "      <param>\n" +
                "         <value>\n" +
                "            <struct>\n" +
                "               <member>\n" +
                "                  <name>originNodeType</name>\n" +
                "                  <value>\n" +
                "                     <string>AIR</string>\n" +
                "                  </value>\n" +
                "               </member>\n" +
                "               <member>\n" +
                "                  <name>originHostName</name>\n" +
                "                  <value>\n" +
                "                     <string>PRETUPS</string>\n" +
                "                  </value>\n" +
                "               </member>\n" +
                "               <member>\n" +
                "                  <name>originTransactionID</name>\n" +
                "                  <value>\n" +
                "                     <string>20190411083108674014</string>\n" +
                "                  </value>\n" +
                "               </member>\n" +
                "               <member>\n" +
                "                  <name>originTimeStamp</name>\n" +
                "                  <value>\n" +
                "                     <dateTime.iso8601>20180613T18:35:20+0500</dateTime.iso8601>\n" +
                "                  </value>\n" +
                "               </member>\n" +
                "               <member>\n" +
                "                  <name>subscriberNumber</name>\n" +
                "                  <value>\n" +
                "                     <string>50762000014</string>\n" +
                "                  </value>\n" +
                "               </member>\n" +
                "            </struct>\n" +
                "         </value>\n" +
                "      </param>\n" +
                "   </params>\n" +
                "</methodCall>";        
        return stringGetBalance;
    }
        
        String xmlRequestGetBalance(String msisdn, String date, String sequence, String originHostName){   
        String stringGetBalance = "<methodCall>\n" +
        "   <methodName>GetBalanceAndDate</methodName>\n" +
        "   <params>\n" +
        "      <param>\n" +
        "         <value>\n" +
        "            <struct>\n" +
        "               <member>\n" +
        "                  <name>originNodeType</name>\n" +
        "                  <value>\n" +
        "                     <string>AIR</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originHostName</name>\n" +
        "                  <value>\n" +
        "                     <string>"+originHostName+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originTransactionID</name>\n" +
        "                  <value>\n" +
        "                     <string>"+sequence+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originTimeStamp</name>\n" +
        "                  <value>\n" +
        "                     <dateTime.iso8601>"+date+"</dateTime.iso8601>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>subscriberNumber</name>\n" +
        "                  <value>\n" +
        "                     <string>"+msisdn+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "            </struct>\n" +
        "         </value>\n" +
        "      </param>\n" +
        "   </params>\n" +
        "</methodCall>";        
        return stringGetBalance;
    }
    
        String xmlRequestRefill(String msisdn, String date, String sequence, String originHostName, String amount, String currency, String ott){
        String stringRefill = "<methodCall>\n" +
    "   <methodName>Refill</methodName>\n" +
    "   <params>\n" +
    "      <param>\n" +
    "         <value>\n" +
    "            <struct>\n" +
    "               <member>\n" +
    "                  <name>originNodeType</name>\n" +
    "                  <value>\n" +
     //   "                     <string>EXT</string>\n" +
    "                     <string>AIRTTMAF</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>originHostName</name>\n" +
    "                  <value>\n" +
    "                     <string>"+originHostName+"</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>originTransactionID</name>\n" +
    "                  <value>\n" +
    "                     <string>"+sequence+"</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>originTimeStamp</name>\n" +
    "                  <value>\n" +
    "                     <dateTime.iso8601>"+date+"</dateTime.iso8601>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>subscriberNumber</name>\n" +
    "                  <value>\n" +
    "                     <string>"+msisdn+"</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>transactionCode</name>\n" +
    "                  <value>\n" +
    "                     <string>ADJ</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>transactionAmount</name>\n" +
    "                  <value>\n" +
    "                     <string>"+amount+"</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>transactionCurrency</name>\n" +
    "                  <value>\n" +
    "                     <string>"+currency+"</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>externalData1</name>\n" +
    "                  <value>\n" +
    "                     <string>"+ott+"</string>\n" +     
    "                  </value>\n" +
    "               </member>\n" +
    "               <member>\n" +
    "                  <name>refillProfileID</name>\n" +
    "                  <value>\n" +
    "                     <string>R000</string>\n" +
    //"                     <string>AV59</string>\n" +
    "                  </value>\n" +
    "               </member>\n" +
    "            </struct>\n" +
    "         </value>\n" +
    "      </param>\n" +
    "   </params>\n" +
    "</methodCall>";

        return stringRefill;
        }
    
        String xmlRequestUpdateRefill(String msisdn, String date, String sequence, String originHostName, String amount, String currency){
            String stringRefill = "<methodCall>\n" +
            "   <methodName>UpdateBalanceAndDate</methodName>\n" +
            "   <params>\n" +
            "      <param>\n" +
            "         <value>\n" +
            "            <struct>\n" +
            "               <member>\n" +
            "                  <name>originNodeType</name>\n" +
            "                  <value>\n" +
            "                     <string>AIR</string>\n" +
            "                  </value>\n" +
            "               </member>\n" +
            "               <member>\n" +
            "                  <name>originHostName</name>\n" +
            "                  <value>\n" +
            "                     <string>"+originHostName+"</string>\n" +
            "                  </value>\n" +
            "               </member>\n" +
            "               <member>\n" +
            "                  <name>originTransactionID</name>\n" +
            "                  <value>\n" +
            "                     <string>"+sequence+"</string>\n" +
            "                  </value>\n" +
            "               </member>\n" +
            "               <member>\n" +
            "                  <name>originTimeStamp</name>\n" +
            "                  <value>\n" +
            "                     <dateTime.iso8601>"+date+"</dateTime.iso8601>\n" +
            "                  </value>\n" +
            "               </member>\n" +
            "               <member>\n" +
            "                  <name>subscriberNumber</name>\n" +
            "                  <value>\n" +
            "                     <string>"+msisdn+"</string>\n" +
            "                  </value>\n" +
            "               </member>\n" +
            "               <member>\n" +
            "                  <name>transactionCurrency</name>\n" +
            "                  <value>\n" +
            "                     <string>"+currency+"</string>\n" +
            "                  </value>\n" +
            "               </member>\n" +
            "               <member>\n" +
            "                  <name>dedicatedAccountUpdateInformation</name>\n" +
            "                  <value>\n" +
            "                     <array>\n" +
            "                        <data>\n" +
            "                           <value>\n" +
            "                              <struct>\n" +
            "                                 <member>\n" +
            "                                    <name>dedicatedAccountID</name>\n" +
            "                                    <value>\n" +
            "                                       <int>50120</int>\n" +
            "                                    </value>\n" +
            "                                 </member>\n" +
            "                                 <member>\n" +
            "                                    <name>dedicatedAccountValueNew</name>\n" +
            "                                    <value>\n" +
            "                                       <string>"+amount+"</string>\n" +
            "                                    </value>\n" +
            "                                 </member>\n" +
            "                                 <member>\n" +
            "                                    <name>dedicatedAccountUnitType</name>\n" +
            "                                    <value>\n" +
            "                                       <i4>1</i4>\n" +
            "                                    </value>\n" +
            "                                 </member>\n" +
            "                              </struct>\n" +
            "                           </value>\n" +
            "                        </data>\n" +
            "                     </array>\n" +
            "                  </value>\n" +
            "               </member>\n" +           
            "            </struct>\n" +
            "         </value>\n" +
            "      </param>\n" +
            "   </params>\n" +
            "</methodCall>";

            return stringRefill;
    }
                
        String xmlUsageThresholdsAndCounters(String msisdn, String date, String sequence, String originHostName, String currency,long operatorId){
        String stringResetCounter = "<methodCall>\n" +
 "    <methodName>UpdateUsageThresholdsAndCounters</methodName>\n"
                    + "      <params>\n"
                    + "         <param>\n"
                    + "            <value>\n"
                    + "               <struct>\n"
                    + "                     <member>\n"
                    + "                        <name>originNodeType</name>\n"
                    + "                        <value>\n"
                    + "                           <string>AIR</string>\n"
                    + "                        </value>\n"
                    + "                     </member>\n"
                    + "                     <member>\n"
                    + "                        <name>originHostName</name>\n"
                    + "                        <value>\n"
                    + "                           <string>" + originHostName + "</string>\n"
                    + "                        </value>\n"
                    + "                     </member>\n"
                    + "                     <member>\n"
                    + "                        <name>originTransactionID</name>\n"
                    + "                        <value>\n"
                    + "                           <string>" + sequence + "</string>\n"
                    + "                        </value>\n"
                    + "                     </member>\n"
                    + "                     <member>\n"
                    + "                        <name>originTimeStamp</name>\n"
                    + "                        <value>\n"
                    + "                           <dateTime.iso8601>" + date + "</dateTime.iso8601>\n"
                    + "                        </value>\n"
                    + "                     </member>\n"
                    + "                     <member>\n"
                    + "                        <name>subscriberNumber</name>\n"
                    + "                        <value>\n"
                    + "                           <string>" + msisdn + "</string>\n"
                    + "                        </value>\n"
                    + "                     </member>\n"
                    + "                     <member>\n"
                    + "                        <name>originOperatorID</name>\n"
                    + "                        <value>\n"
                    + "                           <string>" + String.valueOf(operatorId) + "</string>\n"
                    + "                        </value>\n"
                    + "                     </member>\n"
                    + "                  <member>\n"
                    + "              <name>transactionCurrency</name>\n"
                    + "               <value>\n"
                    + "                <string>" + currency + "</string>\n"
                    + "               </value>\n"
                    + "             </member>\n"
                    + "                     <member>\n"
                    + "                        <name>usageCounterUpdateInformation</name>\n"
                    + "                        <value>\n"
                    + "                           <array>\n"
                    + "                              <data>\n"
                    + "                                    <value>\n"
                    + "                                       <struct>\n"
                    + "                                             <member>\n"
                    + "                                                <name>usageCounterID</name>\n"
                    + "                                                <value>\n"
                    + "                                                   <i4>50120</i4>\n"
                    + "                                                </value>\n"
                    + "                                             </member>\n"
                    + "                                             <member>\n"
                    + "                                                <name>usageCounterMonetaryValueNew</name>\n"
                    + "                                                <value>\n"
                    + "                                                   <string>0</string>\n"
                    + "                                                </value>\n"
                    + "                                             </member>\n"
                    + "                                       </struct>\n"
                    + "                                    </value>\n"
                    + "                              </data>\n"
                    + "                           </array>\n"
                    + "                        </value>\n"
                    + "                     </member>\n"
                    + "               </struct>\n"
                    + "            </value>\n"
                    + "         </param>\n"
                    + "      </params>\n"
                    + "   </methodCall>";

            return stringResetCounter;
         }
        
        String xmlUpdateOffer(String msisdn, String date, String sequence, String originHostName, String amount, String currency,String offerID){
            String stringRefill = "<methodCall>\n"
                    + "	<methodName>UpdateOffer</methodName>\n"
                    + "	<params>\n"
                    + "		<param>\n"
                    + "			<value>\n"
                    + "				<struct>\n"
                    + "					<member>\n"
                    + "						<name>originNodeType</name>\n"
                    + "						<value>\n"
                    + "							<string>AIR</string>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>originHostName</name>\n"
                    + "						<value>\n"
                    + "							<string>"+originHostName+"</string>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>originTransactionID</name>\n"
                    + "						<value>\n"
                    + "							<string>" + sequence + "</string>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>originTimeStamp</name>\n"
                    + "						<value>\n"
                    + "							<dateTime.iso8601>"+date+"</dateTime.iso8601>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>subscriberNumber</name>\n"
                    + "						<value>\n"
                    + "							<string>"+msisdn+"</string>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>subscriberNumberNAI</name>\n"
                    + "						<value>\n"
                    + "							<i4>1</i4>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>offerID</name>\n"
                    + "						<value>\n"
                    + "							<i4>"+offerID+"</i4>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>offerType</name>\n"
                    + "						<value>\n"
                    + "							<i4>2</i4>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>attributeUpdateInformationList</name>\n"
                    + "						<value>\n"
                    + "							<array>\n"
                    + "								<data>\n"
                    + "									<value>\n"
                    + "										<struct>\n"
                    + "											<member>\n"
                    + "												<name>attributeName</name>\n"
                    + "												<value>\n"
                    + "													<string>limiteConsumo</string>\n"
                    + "												</value>\n"
                    + "											</member>\n"
                    + "											<member>\n"
                    + "												<name>attributeUpdateAction</name>\n"
                    + "												<value>\n"
                    + "													<string>SET</string>\n"
                    + "												</value>\n"
                    + "											</member>\n"
                    + "											<member>\n"
                    + "												<name>attributeValueDecimal</name>\n"
                    + "												<value>\n"
                    + "													<struct>\n"
                    + "														<member>\n"
                    + "															<name>attributeValueNumber</name>\n"
                    + "															<value>\n"
                    + "																<string>"+amount+"</string>\n"
                    + "															</value>\n"
                    + "														</member>\n"
                    + "														<member>\n"
                    + "															<name>numberOfDecimals</name>\n"
                    + "															<value>\n"
                    + "																<int>5</int>\n"
                    + "															</value>\n"
                    + "														</member>\n"
                    + "													</struct>\n"
                    + "												</value>\n"
                    + "											</member>\n"
                    + "										</struct>\n"
                    + "									</value>\n"
                    + "									<value>\n"
                    + "										<struct>\n"
                    + "											<member>\n"
                    + "												<name>attributeName</name>\n"
                    + "												<value>\n"
                    + "												<string>perfilCliente</string>\n"
                    + "												</value>\n"
                    + "											</member>\n"
                    + "											<member>\n"
                    + "											<name>attributeUpdateAction</name>\n"
                    + "											<value>\n"
                    + "											<string>SET</string>\n"
                    + "											</value>\n"
                    + "											</member>\n"
                    + "											<member>\n"
                    + "												<name>attributeValueString</name>\n"
                    + "												<value>\n"
                    + "												<string>A</string>\n"
                    + "												</value>\n"
                    + "											</member>\n"
                    + "										</struct>\n"
                    + "									</value>\n"
                    + "								</data>\n"
                    + "							</array>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>requestAttributesFlag</name>\n"
                    + "						<value>\n"
                    + "							<boolean>1</boolean>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "					<member>\n"
                    + "						<name>negotiatedCapabilities</name>\n"
                    + "						<value>\n"
                    + "							<array>\n"
                    + "								<data>\n"
                    + "									<value>\n"
                    + "										<i4>65536</i4>\n"
                    + "									</value>\n"
                    + "								</data>\n"
                    + "							</array>\n"
                    + "						</value>\n"
                    + "					</member>\n"
                    + "				</struct>\n"
                    + "			</value>\n"
                    + "		</param>\n"
                    + "	</params>\n"
                    + "</methodCall>";

            return stringRefill;
        }
        
        String xmlRunPeriodicAccountManagement(String msisdn, String date, String sequence, String originHostName, String amount, String currency,long operatorId){
            String stringRefill = "<methodCall>\n"
                    + "<methodName>RunPeriodicAccountManagement</methodName>\n"
                    + "<params>\n"
                    + "  <param>\n"
                    + "   <value>\n"
                    + "    <struct>\n"
                    + "     <member>\n"
                    + "      <name>originHostName</name>\n"
                    + "      <value><string>"+originHostName+"</string></value>\n"
                    + "     </member>\n"
                    + "     <member>\n"
                    + "      <name>originNodeType</name>\n"
                    + "      <value><string>AIR</string></value>\n"
                    + "     </member>\n"
                    + "     <member>\n"
                    + "      <name>originOperatorID</name>\n"
                    + "      <value><string>"+String.valueOf(operatorId)+"</string></value>\n"
                    + "     </member>\n"
                    + "     <member>\n"
                    + "      <name>originTimeStamp</name>\n"
                    + "      <value><dateTime.iso8601>"+date+"</dateTime.iso8601></value>\n"
                    + "     </member>\n"
                    + "     <member>\n"
                    + "      <name>originTransactionID</name>\n"
                    + "      <value><string>"+sequence+"</string></value>\n"
                    + "     </member>\n"
                    + "     <member>\n"
                    + "      <name>subscriberNumber</name>\n"
                    + "      <value><string>"+msisdn+"</string></value>\n"
                    + "     </member>\n"
                    + "     <member>\n"
                    + "      <name>subscriberNumberNAI</name>\n"
                    + "      <value><i4>1</i4></value>\n"
                    + "     </member>\n"
                    + "         <member>\n"
                    + "      <name>pamServiceID</name>\n"
                    + "      <value><i4>1</i4></value>\n"
                    + "     </member>\n"
                    + "     <member>\n"
                    + "<name>pamIndicator</name>\n"
                    + "<value><i4>50120</i4></value>\n"
                    + "</member>\n"
                    + "    </struct>\n"
                    + "   </value>\n"
                    + "  </param>\n"
                    + "</params>\n"
                    + "</methodCall>";

            return stringRefill;
        }

        String xmlRequestGetUsageThresholdsAndCounters(String msisdn, String date, String sequence, String originHostName){   
        String stringGetBalance = "<methodCall>\n" +
        "   <methodName>GetUsageThresholdsAndCounters</methodName>\n" +
        "   <params>\n" +
        "      <param>\n" +
        "         <value>\n" +
        "            <struct>\n" +
        "               <member>\n" +
        "                  <name>originNodeType</name>\n" +
        "                  <value>\n" +
        "                     <string>AIR</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originHostName</name>\n" +
        "                  <value>\n" +
        "                     <string>"+originHostName+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originTransactionID</name>\n" +
        "                  <value>\n" +
        "                     <string>"+sequence+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>originTimeStamp</name>\n" +
        "                  <value>\n" +
        "                     <dateTime.iso8601>"+date+"</dateTime.iso8601>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "               <member>\n" +
        "                  <name>subscriberNumber</name>\n" +
        "                  <value>\n" +
        "                     <string>"+msisdn+"</string>\n" +
        "                  </value>\n" +
        "               </member>\n" +
        "            </struct>\n" +
        "         </value>\n" +
        "      </param>\n" +
        "   </params>\n" +
        "</methodCall>";        
        return stringGetBalance;
    }
        
        String xmlGetUsageThresholdsAndCounters(String msisdn,String date, String sequence, String originHostName){
        String stringGetBalance ="<methodCall>\n" +
                                "<methodName>GetUsageThresholdsAndCounters</methodName>\n" +
                                "<params>\n" +
                                " <param>\n" +
                                "  <value>\n" +
                                "   <struct>\n" +
                                "    <member>\n" +
                                "     <name>originNodeType</name>\n" +
                                "     <value>\n" +
                                "      <string>AIR</string>\n" +
                                "     </value>\n" +
                                "    </member>\n" +
                                "    <member>\n" +
                                "     <name>originHostName</name>\n" +
                                "     <value>\n" +
                                "      <string>"+originHostName+"</string>\n" +
                                "     </value>\n" +
                                "    </member>\n" +
                                "    <member>\n" +
                                "     <name>originTransactionID</name>\n" +
                                "     <value>\n" +
                                "      <string>"+sequence+"</string>\n" +
                                "     </value>\n" +
                                "    </member>\n" +
                                "    <member>\n" +
                                "     <name>originTimeStamp</name>\n" +
                                "     <value>\n" +
                                "      <dateTime.iso8601>"+date+"</dateTime.iso8601>\n" +
                                "     </value>\n" +
                                "    </member>\n" +
                                "    <member>\n" +
                                "     <name>subscriberNumberNAI</name>\n" +
                                "     <value>\n" +
                                "      <int>1</int>\n" +
                                "     </value>\n" +
                                "    </member>\n" +
                                "    <member>\n" +
                                "     <name>subscriberNumber</name>\n" +
                                "     <value>\n" +
                                "      <string>"+msisdn+"</string>\n" +
                                "     </value>\n" +
                                "    </member>\n" +
                                "   </struct>\n" +
                                "  </value>\n" +
                                " </param>\n" +
                                "</params>\n" +
                                "</methodCall>";
        
        
        
        
        
        
        
        
        
        return stringGetBalance;
        }
        
    }
