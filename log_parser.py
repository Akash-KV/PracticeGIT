import re, requests
import argparse, sys

# Argument Parser
parser = argparse.ArgumentParser()
parser.add_argument('-l', help='Log argument')
args = parser.parse_args()

# Configurations
log = args.l

# filename = './test.txt'
filename = log
data = ''

messages = ""
with open(filename, 'r') as file:
    data = file.readlines()

# for lines in data:
#     if "MBT-FAILED-TEST" in str(lines):
#         line = lines.replace("\n", "")
#         message = "```" + "[FAIL-LOG]: " + line + "```"
#         print(message)
errors = []
for lines in data:
    if "MBT-ERROR" in str(lines) and str(lines) not in errors:
        line = lines.replace("\n", "")
        message = "```" + "[FAIL-LOG]: " + line + "```"
        errors.append(lines)
        print(message)
        sys.exit(0)
    # if "BUILD FAILURE" in str(lines) and str(lines) not in str(errors):
    #     line = lines.replace("\n", "")
    #     line = line.replace("[INFO]", "")
    #     message = "```" + "[FAIL-LOG]: " + line + "```"
    #     errors.append(lines)
    #     print(message)
    #     print(message)
    if "[main] ERROR" in str(lines) and str(lines) not in errors:
        line = lines.replace("\n", "")
        line = line.replace("[INFO]", "")
        line = line.replace("'", "")
        message = "```" + "[FAIL-LOG]: " + line + "```"
        errors.append(lines)
		print(message)
        sys.exit(0)
