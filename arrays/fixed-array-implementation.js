function FixedArray(type, length) {
    /**
     * Simulating a Fixed Array
     *
     * Main Ideas:
     * 1. Receive a Type and find its Word Size,
     * 2. Receive a Length and find the longest contiguous memory needed.
     *
     */

    // Object's Properties (Start)

    this.type = type;
    this.length = length;
    this.baseAddress = getBaseAddress();

    switch (type) {
        case 'int':
            this.stride = 4;
    }

    this.data = new Array(this.baseAddress + this.stride * length);

    // Object's Properties (End)

    // Object's Methods (Start)

    FixedArray.prototype.computeIndexAddress(index) {
        return this.baseAddress + this.stride * index;
    }

    FixedArray.prototype.get(index) {
        var i = this.computeIndexAddress(index);

        return this.data[i];
    }

    FixedArray.prototype.set(index, elem) {
        var i = this.computeIndexAddress(index);

        this.data[i] = elem;
    }

};

function getBaseAddress() {
    return 0;
}

