#!/bin/bash

# Prompt the user to enter a number
echo "Please enter a number:"
read number

# Check if the input is a valid number
if ! [[ "$number" =~ ^[0-9]+$ ]]; then
    echo "Invalid input. Please enter a positive integer."
    exit 1
fi

# Loop to print numbers from 1 to the entered number
for ((i=1; i<=number; i++)); do
    echo $i
done
