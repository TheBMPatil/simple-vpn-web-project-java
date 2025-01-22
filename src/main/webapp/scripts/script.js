document.getElementById("connect-button").addEventListener("click", () => {
    const location = document.getElementById("location-dropdown").value;
    const button = document.getElementById("connect-button");
    const statusElement = document.getElementById("status");

    if (button.innerText === "Connect") {
        // Ensure a location is selected before attempting to connect
        if (!location) {
            alert("Please select a location.");
            return;
        }

        // Connect to VPN
        fetch("connect", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: `location=${location}`,
        })
        .then((response) => response.json())
        .then((data) => {
            if (data.status === "Connected") {
                statusElement.innerText = "Status: Connected";
                button.innerText = "Disconnect";  // Change button text to Disconnect
            } else {
                statusElement.innerText = "Status: Failed to connect";
            }
        })
        .catch((error) => console.error("Error:", error));
    } else if (button.innerText === "Disconnect") {
        // Disconnect from VPN
        fetch("disconnect", {
            method: "POST",
        })
        .then(() => {
            statusElement.innerText = "Status: Disconnected";
            button.innerText = "Connect";  // Change button text back to Connect
        })
        .catch((error) => console.error("Error:", error));
    }
});
