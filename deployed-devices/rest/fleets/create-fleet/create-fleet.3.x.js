// To set up environmental variables, see http://twil.io/secure
const accountSid = process.env.TWILIO_ACCOUNT_SID;
const authToken = process.env.TWILIO_AUTH_TOKEN;
const Twilio = require('twilio').Twilio;

const client = new Twilio(accountSid, authToken);

client.preview.deployed_devices.fleets
  .create({
    friendlyName: 'My Fleet of Devices',
  })
  .then(response => {
    console.log(response);
  })
  .catch(error => {
    console.log(error);
  });
