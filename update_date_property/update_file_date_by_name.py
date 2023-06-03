import os
import sys
from dateutil.parser import parse
import filedate


def main(root_dir):
    if not os.path.exists(root_dir):
        print(f"Path \"{root_dir}\" does not exist")
        return		
    total_counter = 0
    modified_counter = 0
    for subdir, dirs, files in os.walk(root_dir):
        for file in files:
            full_path = os.path.join(subdir, file)
            modified_counter += modify_time_by_name(full_path)
            total_counter += 1
    print(f"Updated {modified_counter} files out of {total_counter}")


def modify_time_by_name(path):
    filename_str = get_name_as_date_str(path)
    try:
        if len(filename_str) > 16 or len(filename_str) < 14:
            return 0  # Not in  a known date format
        parsed_date = parse(filename_str)
        time_as_epoch = parsed_date.timestamp()
    except ValueError as e:
        if "Unknown string format" in e.args[0]:
            print(f"ERROR! File name <{path}> does not contain a date")
            return 0
        else:
            print(f"ERROR! File name <{path}> is not a valid date: {e}")
            return 0
    except BaseException as e:
        print(f"Unknown Error on file {path}: {e}")
        return 0

    curr_modified = os.path.getmtime(path)
    if time_as_epoch == curr_modified:  # time is already up-to-date
        return 0
    filedate.File(path).set(
        created=parsed_date.strftime("%Y%m%d, %H:%M:%S"),
        modified=parsed_date.strftime("%Y%m%d, %H:%M:%S")
    )
    return 1


def get_name_as_date_str(path):
    filename = os.path.basename(path).split('.')[0]             # remove extension
    filename = filename.replace("_", " ")                       # remove separator, if exists
    filename = filename.replace("IMG", "").replace("VID", "")   # remove media prefix
    return filename


if __name__ == '__main__':
    if len(sys.argv) < 2:
        print("Missing directory argument")
        exit(1)
    root_dir_path = sys.argv[1]
    main(root_dir_path)
    print("Done!")
