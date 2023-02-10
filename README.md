Elytron No-Credential
=====================

An Elytron `CredentialStoreSpi` that supports null passwords. You may want to use this for [passwordless truststores](https://bugs.openjdk.org/browse/JDK-8274862).

Usage
-----

```xml
            <providers>
                <aggregate-providers name="combined-providers">
                    <providers name="NoPasswordProvider"/>
                </aggregate-providers>
                <provider-loader name="NoPasswordProvider" module="com.github.marschall.nocredential"/>
            </providers>
            <credential-stores>
              <credential-store name="no-credential-store" provider-name="NoPasswordProvider" modifiable="false" type="no-password">
                <credential-reference clear-text="ignored-only-for-validity"/>
              </credential-store>
            </credential-stores>
            <tls>
                <key-stores>
                    <key-store name="passwordless-pkcs12-KS">
                        <credential-reference store="no-credential-store" alias="ignored-alias"/>
                        <implementation type="PKCS12"/>
                        <file path="no-password.p12" relative-to="jboss.server.config.dir" required="true"/>
                    </key-store>
                </key-stores>
                <trust-managers>
                  <trust-manager name="passwordless-pkcs12-TS" key-store="passwordless-pkcs12-KS"/>
                </trust-managers>
                <server-ssl-contexts>
                    <server-ssl-context trust-manager="passwordless-pkcs12-TS"/>
                </server-ssl-contexts>
            </tls>
```
