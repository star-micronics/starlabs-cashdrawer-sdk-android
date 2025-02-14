# USB CashDrawer SDK
SDK for SMD2 Max and CD3 Value series USB Cash Drawers.  
More info on the Cash Drawers can be found on our [website](https://www.starmicronics.com/pages/pos-cash-register-drawers).

This SDK is distributed as an Android Library (AAR) and a sample app is provided to demonstrate usage.  

## Star Labs
This SDK is a Star Labs project meaning that it is created and released, under an open source license, by Star Micronics employees or subsidiaries, but is not an official Star Micronics software product and not subject to the same guarantees, support or testing requirements from Star Micronics Co Ltd, Japan. As a result, quality, reliability and global support availability will vary between Star Labs projects, please check the project specific support information for details.

## Star Labs Project Status
This project has been developed by Star Micronics America and is safe to use in production.  
Direct support is provided for the following regions: USA, Canada, Latin & Central America, and the Carribean. 

## Getting Started

Run the included Android Studio project or add the AAR to you own project.

## Adding Dependencies

File :arrow_right: Project Structure :arrow_right: Dependencies :arrow_right: JAR dependency
![Add Dependencies](https://starmicronics.altervista.org/cashdrawersdk/documentation/images/add-dependencies.jpg)

## Add your imports

To access the **CashDrawer** class  
`import com.starmicronics.labs.CashDrawer;`  

The **CashDrawer** class provides functions for discovery, checking status and opening the CashDrawer.

## USB Cash Drawer PID/VID Information
The PID (Product ID) of our USB cash drawers can change based on the DIP switch settings. This feature is intentional in case users have multiple drawers and want them to be distinguishable by software.

The VID (Vendor ID) for Star Micronics USB cash drawers is 0519 (in HEX). The PID, however, can vary depending on the DIP switch settings on the back of the cash drawer, which control the USB ID.

## DIP Switch Settings for USB IDs
The following table outlines how the DIP switches should be configured to assign a specific USB ID. The default factory setting is USB ID 1011, with all switches set to 0 (OFF).

<img width="685" alt="viv_pid1" src="https://github.com/user-attachments/assets/50049b44-1382-4590-a83f-02e14c975359" />

## USB Interface PIDs
The PID changes based on the DIP switch settings (USB ID). Here’s how the USB ID relates to the PID:

- USB ID 1011: Default PID
- USB IDs 1012 - 1018: Custom PIDs, assigned based on the DIP switch configurations.
  
This customization allows users to track multiple drawers and distinguish them within their software environment.

## Documentation
[API Reference](https://starmicronics.altervista.org/cashdrawersdk/documentation/)
