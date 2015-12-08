function Product(e, f, g, h) {
    this.productID = ko.observable(e);
    this.productName = ko.observable(f);
    this.price = ko.observable(g).extend({
        numeric: 2
    });
    this.quantity = ko.observable(h).extend({
        numeric: 0
    });
    this.total = ko.dependentObservable(function() {
        return this.price() * this.quantity();
    }, this);
}

// Invoice Object
function Invoice(e, f, g) {
    return {
        customerName: ko.observable(e),
        date: ko.observable(f),
        invoiceNumber: ko.observable(g),
        productList: ko.observableArray()
    };
}

var dataFromServer = [{
    productID: 1,
    productName: "Apple",
    price: 10,
    quantity: 10
}, {
    productID: 2,
    productName: "Banana",
    price: 10,
    quantity: 10
}, {
    productID: 3,
    productName: "Egg",
    price: 10,
    quantity: 10
}, {
    productID: 4,
    productName: "Pear",
    price: 10,
    quantity: 10
}];

var mappedProducts = ko.utils.arrayMap(dataFromServer, function(product) {
    return new Product(product.productID, product.productName, product.price, product.quantity);
});

var MyModel = function() {
    var self = this;

    // All the products
    self.Products = ko.observableArray(mappedProducts);

    self.Invoice = new Invoice();
    self.SearchTerm = ko.observable("");
    self.ModalTitle = ko.observable("");
    self.ModalBody = ko.observable("");

    self.FilteredProducts = ko.computed(function() {
        var filter = self.SearchTerm().toLowerCase();
        if (!filter) {
            return self.Products();
        } else {
            return ko.utils.arrayFilter(self.Products(), function(product) {
                return product.productName().toLowerCase().indexOf(filter) > -1;
            });
        }
    });

    // Add Product Quantity
    self.addQuantity = function(product) {
        product.quantity(product.quantity() + 1);
    };

    // Reduce Product Quantity
    self.reduceQuantity = function(product) {
        var q = product.quantity();
        if (q > 1) {
            product.quantity(q - 1);
        }
    };

    // Save invoice in the local storage
    self.saveInvoice = function() {
        localStorage.invoice = ko.toJSON(this.Invoice);
    };

    // Load saved invoice from local storage
    self.loadUnsubmitInvoice = function() {
        var invoice = ko.utils.parseJson(localStorage.invoice);
        if (invoice) {
            self.Invoice = new Invoice(invoice.customerName, invoice.date, invoice.invoiceNumber);
        } else {
            self.Invoice = new Invoice();
        }
    };
    self.loadUnsubmitInvoice();

    self.submitInvoice = function() {
        if (self.Invoice.customerName() && self.Invoice.invoiceNumber() && self.Invoice.date()) {
            self.ModalTitle("Success");
            self.ModalBody(this.Invoice.customerName() + " " + this.Invoice.invoiceNumber());
            // submit invoice to the server
            localStorage.removeItem("invoice");
        } else {
            self.ModalTitle("Fail");
            self.ModalBody("You have to fill all fields");
        }
        $('#confirmModal').modal();
    };
};


ko.extenders.numeric = function(target, precision) {
    var result = ko.pureComputed({
        read: target,
        write: function(newValue) {
            var current = target(),
                roundingMultiplier = Math.pow(10, precision),
                newValueAsNum = isNaN(newValue) ? current : parseFloat(+newValue),
                valueToWrite = Math.round(newValueAsNum * roundingMultiplier) / roundingMultiplier;

            //only write if it changed
            if (valueToWrite !== current) {
                target(valueToWrite);
            } else {
                if (newValue !== current) {
                    target.notifySubscribers(valueToWrite);
                }
            }
        }
    }).extend({
        notify: 'always'
    });

    result(target());

    return result;
};