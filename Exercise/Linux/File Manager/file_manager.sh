#!/bin/bash

# Define a directory and an array of filenames
directory="./test_files"
files=("file1.txt" "file2.txt" "file3.log" "file4.log")

# Function to create files
create_files() {
    local dir=$1
    local filenames=("${@:2}")
    mkdir -p "$dir"  # Create the directory if it doesn't exist
    for file in "${filenames[@]}"; do
        touch "$dir/$file"  # Create each file
        echo "Created file: $dir/$file"
    done
}

# Function to check file existence and size
check_files() {
    local dir=$1
    local filenames=("${@:2}")
    for file in "${filenames[@]}"; do
        local filepath="$dir/$file"
        if [ -e "$filepath" ]; then
            local filesize=$(stat -c%s "$filepath")
            echo "File: $filepath exists and its size is ${filesize} bytes."
        else
            echo "File: $filepath does not exist."
        fi
    done
}

# Function to remove files based on extension
remove_files_by_extension() {
    local dir=$1
    local extension=$2
    local files_to_remove=($(find "$dir" -type f -name "*$extension"))
    for file in "${files_to_remove[@]}"; do
        rm "$file"
        echo "Removed file: $file"
    done
}

# Main script execution
echo "Starting file management process..."

# Create files
create_files "$directory" "${files[@]}"

# Check file existence and size
check_files "$directory" "${files[@]}"

# Remove files with the .log extension
remove_files_by_extension "$directory" ".log"

# Final report
echo "File management process completed."
