# Zimplistic-android
Zimplistic-android

A simple android native app using socket.io android client lib for realtime app

## Setup / Usage 

```
- Change the ROTIMATIC_SERVER_URL from  app/src/main/java/com/zimplistic/rotimatic/Constants.java to appropriate URL ( either http:localhost:3000 or http://10.0.3.2:3000 ( genymotion ) ,  http://10.0.2.2:3000 ( android emulator ) )
- Build the app and launch ( make sure you have internet connectivity )
```

## Description
- The app has interface to send commands to rotimatic machine emulator
- Please see Rotimatic Commands to see available commands 

## Rotimatic Commands
- `ON DEVICE`
- `OFF DEVICE`
- `COOK <num_of_rotis>`
