# Send mail

Code that allows you to send email using a GMAIL account with SMTP.

You can send an email with plain text or html and that contains an attachment.

## Requirements

* java
* javax.mail -> Look at the pom.xml file.
* **Enable insecure connections** https://myaccount.google.com/lesssecureapps


## Usage

Use the SendMail constructor with the varials:

* **to**: recipient's email address.
* **from**: sender's email address.
* **password**: password of the sender.
* **host**: email server.
* **subject**: Subject of the email.
* **urlAttach**: Path where the attachment is located. If not defined, an attachment is not sent.
* **msg**: Body of the email message.
* **isHTML**. If you want to send a msg that is in HTML format, set it to true.


## License
[MIT](https://choosealicense.com/licenses/mit/)