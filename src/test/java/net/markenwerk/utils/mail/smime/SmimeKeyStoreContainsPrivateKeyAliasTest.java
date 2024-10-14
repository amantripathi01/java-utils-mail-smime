/*
 * Copyright (c) 2015 Torsten Krause, Markenwerk GmbH.
 * 
 * This file is part of 'A S/MIME library for JavaMail', hereafter
 * called 'this library', identified by the following coordinates:
 * 
 *    groupID: net.markenwerk
 *    artifactId: utils-mail-smime
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 * 
 * See the LICENSE and NOTICE files in the root directory for further
 * information.
 */
// ********RoostGPT********
/*
Test generated by RoostGPT for test aman15thMaygitlab using AI Type  and AI Model 

ROOST_METHOD_HASH=containsPrivateKeyAlias_6d4550f3d9
ROOST_METHOD_SIG_HASH=containsPrivateKeyAlias_cb04a7c4b5

"""
Scenario 1: Testing for alias existence in the keystore

Details:  
  TestName: testAliasExistence
  Description: This test aims to check whether the method correctly identifies the presence of a given alias in the keystore. The scenario to be tested is when the alias is indeed present in the keystore.
Execution:
  Arrange: Initialize a SmimeKeyStore object and add a known alias to the keystore.
  Act: Call the containsPrivateKeyAlias method with the known alias as a parameter.
  Assert: The method should return true.
Validation: 
  The assertion verifies that the method correctly identifies the presence of the alias in the keystore. This is crucial for the application's functionality as it ensures accurate retrieval of keys based on their aliases.

Scenario 2: Testing for alias non-existence in the keystore

Details:  
  TestName: testAliasNonExistence
  Description: This test aims to check whether the method correctly identifies the absence of a given alias in the keystore. The scenario to be tested is when the alias is not present in the keystore.
Execution:
  Arrange: Initialize a SmimeKeyStore object without adding any alias to the keystore.
  Act: Call the containsPrivateKeyAlias method with a random alias as a parameter.
  Assert: The method should return false.
Validation: 
  The assertion verifies that the method correctly identifies the absence of the alias in the keystore. This is important for the application's functionality as it prevents attempts to retrieve non-existent keys.

Scenario 3: Testing the method's error handling

Details: 
  TestName: testErrorHandling
  Description: This test aims to check whether the method correctly handles errors that might occur during its execution. The scenario to be tested is when an exception is thrown while trying to access the keystore.
Execution:
  Arrange: Initialize a mock SmimeKeyStore object and configure it to throw an exception when the isKeyEntry method is called.
  Act: Call the containsPrivateKeyAlias method with any alias as a parameter.
  Assert: The method should throw a SmimeException.
Validation: 
  The assertion verifies that the method correctly handles exceptions by throwing a SmimeException. This is important for the application's error handling and debugging as it ensures that errors are correctly reported and traced.
"""
*/

// ********RoostGPT********

package net.markenwerk.utils.mail.smime;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import java.io.InputStream;
import java.security.KeyStore;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class SmimeKeyStoreContainsPrivateKeyAliasTest {
    private KeyStore keyStoreMock;
    private SmimeKeyStore smimeKeyStore;
    @Before
    public void setUp() throws Exception {
        keyStoreMock = Mockito.mock(KeyStore.class);
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        InputStream stream = Mockito.mock(InputStream.class);
        smimeKeyStore = new SmimeKeyStore(stream, password);
        smimeKeyStore.keyStore = keyStoreMock;
    }
    @Test
    @Category(Categories.valid.class)
    public void testAliasExistence() throws Exception {
        String alias = "alias";
        when(keyStoreMock.isKeyEntry(alias)).thenReturn(true);
        assertTrue(smimeKeyStore.containsPrivateKeyAlias(alias));
    }
    @Test
    @Category(Categories.valid.class)
    public void testAliasNonExistence() throws Exception {
        String alias = "alias";
        when(keyStoreMock.isKeyEntry(alias)).thenReturn(false);
        assertFalse(smimeKeyStore.containsPrivateKeyAlias(alias));
    }
    @Test(expected = SmimeException.class)
    @Category(Categories.invalid.class)
    public void testErrorHandling() throws Exception {
        String alias = "alias";
        when(keyStoreMock.isKeyEntry(alias)).thenThrow(new KeyStoreException());
        smimeKeyStore.containsPrivateKeyAlias(alias);
    }
}