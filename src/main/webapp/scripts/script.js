document.getElementById("connect-button").addEventListener("click", () => {
	const location = document.getElementById("location-dropdown").value;
	console.log("Hello")
	fetch("connect", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded",
		},
		body: `location=${location}`,
	})
		.then((response) => response.json())
		.then((data) => {
			document.getElementById("status").innerText = `Status: ${data.status}`;
		})
		.catch((error) => console.error("Error:", error));
});
