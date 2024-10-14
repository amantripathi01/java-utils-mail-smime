package net.markenwerk.utils.mail.smime;
 public interface Categories{
    
      interface valid{}
      interface invalid{}
      interface boundary{}
      interface integration{}
    interface getPrivateKey{}
    
    
   interface getCertificate{}
 interface getCertificateChain{}
 interface getAssociatedAddresses{}
interface extractAssociatedAddresses{}
 interface size{}
 
 interface containsPrivateKeyAlias{}
interface copy{}
interface overwrite{}
 interface getPrivateKeyAliases{}
 
 interface encrypt{}
interface copyHeaders{}
interface prepareGenerator{}
interface prepareEncryptor{}
interface copyContent{}
interface handledException{}
 
 interface decrypt{}
interface decryptContent{}
interface copyHeaderLines{}
 
 
 interface sign{}
interface getGenerator{}
interface canonicalize{}
}