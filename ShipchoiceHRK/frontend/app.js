const deliveryOptions = document.getElementById('select-delivery-patner')
const deliveryCost = document.querySelector(".cost")
const deliverydays = document.querySelector('.days')

const deliveryDetails = {
    DHL: {
        cost: 70,
        days: 1
    },
    BlueDart: {
        cost: 50,
        days: 2
    },
    DTDC: {
        cost: 40,
        days: 3
    }
}


function changePatner() {
    const value = deliveryOptions.value
    console.log(value)
    switch (value) {
        case 'DHL':
            deliveryCost.textContent = `Cost: ₹${deliveryDetails['DHL'].cost}`
            deliverydays.textContent = `Estimated Delivery Time: ${deliveryDetails['DHL'].days} day`
            break;
        case 'BlueDart':
            deliveryCost.textContent = `Cost: ₹${deliveryDetails['BlueDart'].cost}`
            deliverydays.textContent = `Estimated Delivery Time: ${deliveryDetails['BlueDart'].days} day`
            break;
        case 'DTDC':
            deliveryCost.textContent = `Cost: ₹${deliveryDetails['DTDC'].cost}`
            deliverydays.textContent = `Estimated Delivery Time: ${deliveryDetails['DTDC'].days} day`     
            break;
        default:
            break;
    }
}

// Show confirmation popup
function showConfirmationPopup() {
    // Get selected shipping partner and cost
    const partner = document.getElementById('select-delivery-patner').value;
    const costText = document.querySelector('.cost').textContent;
    const shippingCost = costText.replace('Cost: ', '');
    
    // Calculate total amount (product price + shipping)
    const productPrice = 500;
    const shippingCostNumber = parseInt(shippingCost.replace('₹', ''));
    const totalAmount = productPrice + shippingCostNumber;
    
    // Update popup with current values
    document.getElementById('popup-partner').textContent = partner;
    document.getElementById('popup-shipping-cost').textContent = shippingCost;
    document.getElementById('popup-total').textContent = '₹' + totalAmount;
    
    // Show the popup
    document.getElementById('confirmationOverlay').classList.add('active');
}

// Hide confirmation popup
function hideConfirmationPopup() {
    document.getElementById('confirmationOverlay').classList.remove('active');
}