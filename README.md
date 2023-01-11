## Introduction
Test IDP Server for AWS Account SAML 2.0-based federation
https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_providers_saml.html

## Test Preparation
Make your own private key, certificate and add application.yml

```
- private key (passphass + PEM/PKCS#1)
  - ssh-keygen -t rsa -b 2048 -o -a 100 -f id_rsa -m PEM
- certificate
  - openssl req -new -x509 -key id_rsa -out rsacert.pem
```
